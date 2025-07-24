package com.order_management_system.user_service.service;

import com.order_management_system.user_service.model.entity.User;
import com.order_management_system.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersCommandHandler {
    private final UserRepository userRepository;

    public List<User> handle(){
        return userRepository.findAll();
    }
}
