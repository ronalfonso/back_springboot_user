package com.ronaldalfonso.app.users.rest;

import com.ronaldalfonso.app.users.models.dto.ServiceResponse;
import com.ronaldalfonso.app.users.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external")
public class ExternalRest {

    private final ExternalService externalService;

    public ExternalRest(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/{param}")
    public ResponseEntity<ServiceResponse> searchListUserActive(@PathVariable String param) {
        ServiceResponse response = externalService.encodeDES(param);

        return ResponseEntity.status(response.getResponseCode()).body(response);
    }
}
