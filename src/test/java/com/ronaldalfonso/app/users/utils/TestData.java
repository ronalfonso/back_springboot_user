package com.ronaldalfonso.app.users.utils;

import com.ronaldalfonso.app.users.models.entity.Role;
import com.ronaldalfonso.app.users.models.entity.Users;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<Users> getUsersList() {
        List<Users> usersList = new ArrayList<>();
        Role role1 = new Role();
        Role role2 = new Role();
        List<Role> roleList1 = new ArrayList<>();
        List<Role> roleList2 = new ArrayList<>();
        role1.setId(1L);
        role1.setName("ROLE_ADMIN");
        role2.setId(2L);
        role2.setName("ROLE_USER");

        roleList1.add(role1);
        roleList1.add(role2);

        roleList2.add(role2);


        Users user1 = new Users(1L, "admin", "1234", "admin@mail.com", "administrador", "+584246266732", true, false, roleList1);
        Users user2 = new Users(2L, "ron", "1234", "ronald@mail.com", "ronald alfonso", "+584246266732", true, false, roleList2);

        usersList.add(user1);
        usersList.add(user2);

        return usersList;
    }

    public static Users getUser() {
        Role role = new Role();
        List<Role> roleList = new ArrayList<>();
        role.setId(2L);
        role.setName("ROLE_USER");

        roleList.add(role);
        roleList.add(role);

        Users user1 = new Users(1L, "ronalfonso", "1234", "ronald@mail.com", "ronald alfonso", "+584246266732", true, false, roleList);

        return user1;
    }
}
