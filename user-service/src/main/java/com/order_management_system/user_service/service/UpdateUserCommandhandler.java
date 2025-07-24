package com.order_management_system.user_service.service;

import com.order_management_system.user_service.model.command.CreateUserCommand;
import com.order_management_system.user_service.model.command.UpdateUserCommand;
import com.order_management_system.user_service.model.entity.User;
import com.order_management_system.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserCommandHandler {
    private final UserRepository userRepository;

    public User handle(String userId, UpdateUserCommand command){
        User existing = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User does not exist with ID" + userId));
        existing.setName(command.getName());
        existing.setEmail(command.getEmail());
        existing.setPhoneNumber(command.getPhoneNumber());
        existing.setAddress(command.getAddress());
        return userRepository.save(existing);
    }
}
