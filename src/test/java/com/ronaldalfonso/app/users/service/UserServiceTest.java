package com.ronaldalfonso.app.users.service;

import com.ronaldalfonso.app.users.models.dto.ServiceResponse;
import com.ronaldalfonso.app.users.models.entity.Users;
import com.ronaldalfonso.app.users.models.repository.UserRepository;
import com.ronaldalfonso.app.users.utils.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    @DisplayName("searchListUserActive test")
    class searchListUserActive {

        @DisplayName("searchListUserActive OK")
        @Test
        void test1() {
            when(userRepository.searchUserByActiveEquals(true)).thenReturn(TestData.getUsersList());

            ServiceResponse response = userService.searchListUserActive();

            //verifico resultado
            assertNotNull(response);
            assertNotNull(response.getResult());
            assertEquals(2, ((List<Users>) response.getResult()).size());
            assertEquals("ronald alfonso", ((List<Users>) response.getResult()).get(1).getName());
        }


    }

    @Nested
    @DisplayName("detailsUser test")
    class detailsUser {
        @DisplayName("detailsUser OK")
        @Test
        void test1() {
            when(userRepository.findByEmail(anyString())).thenReturn(TestData.getUser());

            ServiceResponse response = userService.detailsUser("ronald@mail.com");

            //verifico resultado
            assertNotNull(response);
            assertNotNull(response.getResult());
            assertEquals("ronald alfonso", ((Users) response.getResult()).getName());
        }

        @DisplayName("detailsUser no OK")
        @Test
        void test2() {
            when(userRepository.findByEmail(anyString())).thenReturn(null);

            ServiceResponse response = userService.detailsUser("admin@mail.com");

            //verifico resultado
            assertNotNull(response);
            assertEquals(response.getResult(), null);
        }
    }

}