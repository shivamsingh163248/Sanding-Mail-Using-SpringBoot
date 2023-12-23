package io.getarray.userservices.service.impl;

import io.getarray.userservices.domain.Confermation;
import io.getarray.userservices.domain.user;
import io.getarray.userservices.repository.ConfirmationRepositary;
import io.getarray.userservices.repository.UserReposetory;
import io.getarray.userservices.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    private final UserReposetory userReposetory ;
    private final ConfirmationRepositary confirmationRepositary ;
    @Override
    public user saveUser(user User) {
        if (userReposetory.existedByEmail(User.getEmail())){
            throw new RuntimeException("email alrady exist") ;

        }
        User.setEnable(false);
        userReposetory.save(User) ;
        Confermation confermation = new Confermation(User) ;
        confirmationRepositary.save(confermation);
        return User;
    }

    @Override
    public boolean varifyToken(String token) {

        Confermation confermation = confirmationRepositary.findByTocken(token);
        user User = userReposetory.findByEmailIgnoreCase(confermation.getUser().getEmail());
        User.setEnable(true);
        // confirmationRepositary.delete(confermation);
        return Boolean.TRUE;
    }
}
