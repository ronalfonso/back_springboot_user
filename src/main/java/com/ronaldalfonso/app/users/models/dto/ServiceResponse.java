package com.ronaldalfonso.app.users.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceResponse {

    private Integer responseCode;
    private String description;
    private Integer enlapsedTime;
    private Object result;

    public static final String STATUS_ERROR = "error";
    public static final String STATUS_SUCCESS = "OK";

    public static final Integer INTERNAL_SERVER_ERROR = 500;
    public static final Integer BAD_REQUEST = 400;
    public static final Integer OK = 200;
}
