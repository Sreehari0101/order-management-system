package com.order_management_system.order_service.client;

import com.order_management_system.order_service.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url= "${user.service.url}")
public interface UserClient {
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable String userId);
}
