package com.ronaldalfonso.app.users.service;

import com.ronaldalfonso.app.users.models.dto.ServiceResponse;
import com.ronaldalfonso.app.users.models.dto.UserCreate;
import com.ronaldalfonso.app.users.models.entity.Role;
import com.ronaldalfonso.app.users.models.entity.Users;
import com.ronaldalfonso.app.users.models.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ServiceResponse searchListUserActive() {
        //<editor-fold defaultstate="collapsed" desc="Se obtiene lista de usuarios activos" >
        Date dateStart = new Date();
        ServiceResponse response = new ServiceResponse();
        List<Users> usersList = null;
        try {
            usersList = userRepository.searchUserByActiveEquals(true);
            Date dateEnd = new Date();
            response.setResult(usersList);
            response.setResponseCode(ServiceResponse.OK);
            response.setDescription(ServiceResponse.STATUS_SUCCESS);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));

        } catch (Exception e) {
            Date dateEnd = new Date();
            response.setResponseCode(ServiceResponse.INTERNAL_SERVER_ERROR);
            response.setDescription(ServiceResponse.STATUS_ERROR);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));
        }

        return response;
        //</editor-fold>
    }

    public ServiceResponse detailsUser(String email) {
        //<editor-fold defaultstate="collapsed" desc="Se obtiene detalle de usuario">
        Date dateStart = new Date();
        ServiceResponse response = new ServiceResponse();

        try {
            Users user = userRepository.findByEmail(email);
            Date dateEnd = new Date();
            response.setResult(user);
            response.setResponseCode(ServiceResponse.OK);
            response.setDescription(ServiceResponse.STATUS_SUCCESS);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));

        } catch (Exception e) {
            Date dateEnd = new Date();
            response.setResponseCode(ServiceResponse.INTERNAL_SERVER_ERROR);
            response.setDescription(ServiceResponse.STATUS_ERROR);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));
        }

        return response;
        //</editor-fold>
    }

    public ServiceResponse createUser(UserCreate user) {
        //<editor-fold defaultstate="collapsed" desc="Se crea usuario">
        Date dateStart = new Date();
        ServiceResponse response = new ServiceResponse();
        Users userByCreate = new Users();
        Role roleDefault = new Role();
        roleDefault.setId(2L);
        roleDefault.setName("ROLE_USER");
        List<Role> rolesDefault = new ArrayList<>();
        rolesDefault.add(roleDefault);

        userByCreate.setUsername(user.getUsername());
        userByCreate.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userByCreate.setEmail(user.getEmail());
        userByCreate.setPhone(user.getPhone());
        userByCreate.setName(user.getName());
        userByCreate.setRole(rolesDefault);

        try {
            Users userResponse = userRepository.save(userByCreate);
            Date dateEnd = new Date();
            response.setResult(userResponse);
            response.setResponseCode(ServiceResponse.OK);
            response.setDescription(ServiceResponse.STATUS_SUCCESS);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));

        } catch (Exception e) {
            Date dateEnd = new Date();
            response.setResponseCode(ServiceResponse.INTERNAL_SERVER_ERROR);
            response.setDescription(ServiceResponse.STATUS_ERROR);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));
        }

        return response;
        //</editor-fold>
    }

    public ServiceResponse deleteUser(Long id) {
        //<editor-fold desc="Se hace un soft delete del usuario">
        Date dateStart = new Date();
        ServiceResponse response = new ServiceResponse();

        try {

            Optional<Users> userFound = userRepository.findById(id);
            if (userFound.isEmpty()) throw new RuntimeException("No se encontro el usuario");
            Users user = userFound.get();
            user.setDeleted(true);
            user.setActive(false);
            userRepository.save(user);
            Date dateEnd = new Date();
            response.setResponseCode(ServiceResponse.OK);
            response.setDescription(ServiceResponse.STATUS_SUCCESS);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));

        } catch (Exception e) {
            Date dateEnd = new Date();
            response.setResponseCode(ServiceResponse.INTERNAL_SERVER_ERROR);
            response.setDescription(ServiceResponse.STATUS_ERROR);
            response.setEnlapsedTime((int) (dateEnd.getTime() - dateStart.getTime()));
        }

        return response;
        //</editor-fold>
    }


}
