package com.ronaldalfonso.app.users.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseExternal {
    private Integer responseCode;
    private String description;
    private ResultExternal result;
}
