package com.ronaldalfonso.app.users.models.repository;

import com.ronaldalfonso.app.users.models.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "users-repository")
public interface UserRepository extends PagingAndSortingRepository<Users, Long> {

    @RestResource(path = "findUserByEmail")
    public Users findByEmailAndActiveAndDeleted(@Param("email") String email, @Param("active") Boolean active, @Param("deleted") Boolean deleted);

    @Query("SELECT u FROM Users u WHERE u.email = ?1 and u.active = ?2 and u.deleted = ?3")
    public Users searchUserByEmail(String email, Boolean active, Boolean deleted);

    public List<Users> searchUserByActiveEquals(Boolean active);

    public Users findByEmail(String email);

}
