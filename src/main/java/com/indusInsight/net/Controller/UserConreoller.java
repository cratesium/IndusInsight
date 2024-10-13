package com.indusInsight.net.Controller;

import com.indusInsight.net.Services.UserServices;
import com.indusInsight.net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/user")
@RestController
public class UserConreoller {
    @Autowired
    UserServices userServices;


    @GetMapping("/getall")
      public List<User> getAllUsers(){
        return userServices.getAllUser();
    }
    @GetMapping("getbyid/{id}")
    public User getUserById(@PathVariable Integer id) throws Exception {
    User user = userServices.findbyid(id);
    return  user;
    }

    @PostMapping("/create")
    public  User createUser(@RequestBody User user){
        User user1= userServices.CreateUser(user);
        return  user1;
    }





}
