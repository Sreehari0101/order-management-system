package com.order_management_system.user_service.service;

import com.order_management_system.user_service.model.command.CreateUserCommand;
import com.order_management_system.user_service.model.entity.User;
import com.order_management_system.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserCommandHandler {
    private final UserRepository userRepository;

    public User handle(CreateUserCommand command){
        User user = User.builder()
                .name(command.getName())
                .email(command.getEmail())
                .phoneNumber(command.getPhoneNumber())
                .address(command.getAddress())
                .build();
        return userRepository.save(user);
    }
}
