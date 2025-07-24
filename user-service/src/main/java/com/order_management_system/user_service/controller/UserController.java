package com.order_management_system.user_service.controller;

import com.order_management_system.user_service.model.command.CreateUserCommand;
import com.order_management_system.user_service.model.command.UpdateUserCommand;
import com.order_management_system.user_service.model.entity.User;
import com.order_management_system.user_service.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final CreateUserCommandHandler createUserCommandHandler;
    private final GetAllUsersCommandHandler getAllUsersCommandHandler;
    private final GetUserCommandHandler getUserCommandHandler;
    private final UpdateUserCommandHandler updateUserCommandHandler;
    private final DeleteUserCommandHandler deleteUserCommandHandler;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserCommand command){
        User user = createUserCommandHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = getAllUsersCommandHandler.handle();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = getUserCommandHandler.handle(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable String userId,
                                               @RequestBody UpdateUserCommand command){
        User user = updateUserCommandHandler.handle(userId, command);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String userId){
        deleteUserCommandHandler.hande(userId);
        return ResponseEntity.noContent().build();
    }


}
