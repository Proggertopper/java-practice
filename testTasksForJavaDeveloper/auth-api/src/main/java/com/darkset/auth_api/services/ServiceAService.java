package com.darkset.auth_api.services;

import com.darkset.auth_api.models.User;
import com.darkset.auth_api.repos.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;


    public User registerUser(String email , String password){
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(encoder.encode(password));
        return usersRepository.save(user);
    }

    public User loginUser(String email , String password){
       User user = usersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

       if(!encoder.matches(password , user.getPasswordHash())){
           throw new RuntimeException("Invalid Password");
       }

       return user;
    }


}
