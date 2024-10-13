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

     public User updateUser(User user ,Integer id) throws  Exception{
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isEmpty())
            throw  new Exception("user id you entered doesnt exist in the database ");
        else {
            if (user.getFirstName()!=null){
                user1.get().setFirstName(user.getFirstName());
            }
            if (user.getLastName()!=null){
                user1.get().setLastName(user.getLastName());
            }
            if (user.getEmail()!=null){
                user1.get().setEmail(user.getEmail());
            }
            if (user.getPassword()!=null){
                user1.get().setPassword(user.getPassword());
            }
        }
        userRepository.save(user1.get());
        return user1.get();
     }
}
