package com.indusInsight.net.Controller;

import com.indusInsight.net.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserConreoller {

    @GetMapping("/getallusers")
   public List<User> getAllUsers(){
        List<User>  list= new ArrayList<>();
        User user = new User("shikhar", "singh" , "shikhar@gmail.com" ,"1234");
        User user1 = new User("shiva", "sharma" , "shiva@gmail.com" ,"1234");
        User user2 = new User("shrishti", "varshney" , "shrishti@gmail.com" ,"1234");
        User user3 = new User("yash", "sharma" , "yash@gmail.com" ,"1234");
        User user4 = new User("prince", "raj" , "bbc@gmail.com" ,"1234");

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return  list;
    }

}
