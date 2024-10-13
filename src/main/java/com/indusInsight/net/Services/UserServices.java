package com.indusInsight.net.Services;

import com.indusInsight.net.Repository.UserRepository;
import com.indusInsight.net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public User CreateUser(User user){

        User user1 = userRepository.save(user);
        return  user1;
    }
     public List<User> getAllUser(){
         List<User> list= userRepository.findAll();
         return  list;
     }
     public  User findbyid(Integer id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return  user.get();
        }
        throw  new Exception("user with given id not present in Db");
     }
}
