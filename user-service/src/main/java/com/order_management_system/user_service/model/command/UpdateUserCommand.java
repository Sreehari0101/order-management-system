package com.order_management_system.user_service.model.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserCommand {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
