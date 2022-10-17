package com.ronaldalfonso.app.users.models.dto;

import com.ronaldalfonso.app.users.models.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreate {

    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private List<Role> roles;

}
