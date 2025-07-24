package com.order_management_system.user_service.service;

import com.order_management_system.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserCommandHandler {
    private final UserRepository userRepository;

    public void hande(String userId){
        if(!userRepository.existsById(userId)){
            throw new RuntimeException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }

}

