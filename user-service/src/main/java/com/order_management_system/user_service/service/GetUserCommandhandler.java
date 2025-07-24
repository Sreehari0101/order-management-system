package com.order_management_system.user_service.service;

import com.order_management_system.user_service.model.entity.User;
import com.order_management_system.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserCommandHandler {
    private final UserRepository userRepository;

    public User handle(String userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID:" + userId));
    }
}
