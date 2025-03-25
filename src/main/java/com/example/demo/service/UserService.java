package com.example.demo.service;



import com.example.demo.usermodel.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    public List<User> getAllUser()  ;

    public User findUserProfileByJwt(String jwt);

    public User findUserByEmail(String email) ;

    public User findUserById(String userId) ;

    public List<User> findAllUsers();


}
