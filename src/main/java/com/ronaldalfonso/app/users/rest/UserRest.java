package com.ronaldalfonso.app.users.rest;

import com.ronaldalfonso.app.users.models.dto.ServiceResponse;
import com.ronaldalfonso.app.users.models.dto.UserCreate;
import com.ronaldalfonso.app.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserRest {

    private final UserService userService;

    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ServiceResponse> searchListUserActive() {
      ServiceResponse response = userService.searchListUserActive();

      return ResponseEntity.status(response.getResponseCode()).body(response);
    }

    @GetMapping("/details")
    public ResponseEntity<ServiceResponse> detailsUser(@RequestParam String email) {
        ServiceResponse response = userService.detailsUser(email);
        return ResponseEntity.status(response.getResponseCode()).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createUser(@RequestBody UserCreate user) {
        ServiceResponse response = userService.createUser(user);
        return ResponseEntity.status(response.getResponseCode()).body(response);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> deleteUser(@PathVariable Long id) {
        ServiceResponse response = userService.deleteUser(id);
        return ResponseEntity.status(response.getResponseCode()).body(response);
    }
}
