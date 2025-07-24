package com.order_management_system.user_service.repository;

import com.order_management_system.user_service.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
