package com.indusInsight.net.Controller;

import com.indusInsight.net.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/user")
@RestController
public class UserConreoller {
    List<User>  list= new ArrayList<>();

    @GetMapping("/getall")
   public List<User> getAllUsers(){
        User user = new User(1,"shikhar", "singh" , "shikhar@gmail.com" ,"1234");
        User user1 = new User(2,"shiva", "sharma" , "shiva@gmail.com" ,"1234");
        User user2 = new User(3,"shrishti", "varshney" , "shrishti@gmail.com" ,"1234");
        User user3 = new User(4,"yash", "sharma" , "yash@gmail.com" ,"1234");
        User user4 = new User(5,"prince", "raj" , "bbc@gmail.com" ,"1234");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return  list;
    }
    @GetMapping("getbyid/{id}")
    public User getUserById(@PathVariable Integer id){
        for( int i=0 ;i< list.size();i++){
            if (list.get(i).getId()==id){
                return list.get(i);
            }

        }
        return  null;
    }





}
