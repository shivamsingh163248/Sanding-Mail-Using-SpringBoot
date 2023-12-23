package io.getarray.userservices.service;

import io.getarray.userservices.domain.user;

public interface UserServices {
    user saveUser(user User) ;
    boolean varifyToken(String token) ;
}



