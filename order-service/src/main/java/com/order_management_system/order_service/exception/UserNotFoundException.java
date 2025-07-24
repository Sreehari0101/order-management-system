package com.order_management_system.order_service.exception;

public class UserNotFoundException extends RuntimeException{
   public UserNotFoundException(String message){
       super(message);
   }
}
