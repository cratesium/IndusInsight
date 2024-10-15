package com.indusInsight.net.Services;

import com.indusInsight.net.Repository.UserRepository;
import com.indusInsight.net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServicesImplementation implements UserServices {


    @Autowired
    UserRepository userRepository;

    @Override
    @PostMapping("create")
    public User registerUser(User user) {
        User user1 = userRepository.save(user);
        return  user1;
    }


    @Override
    public User findUserById(Integer id) throws  Exception {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()){
        throw new Exception("User with id "+id+" cannot be found ");
    }
    return  user.get();

    }

    @Override
    public User findUserByEmail(String email) throws Exception {;
       User user = userRepository.findByEmail(email);
       if (user==null) throw  new Exception("User doesn't exist with this email "+email);
       return  user;
    }

    @Override
    public User followUser(Integer id1, Integer id2) throws Exception {
        User user1= findUserById(id1);
        User user2= findUserById(id2);

        user1.getFollowing().add(user2.getId());
        user2.getFollowers().add(user1.getId());
        userRepository.save(user1);
        userRepository.save(user2);

        return  user1;

    }

    @Override
    public User updateUser(User user,Integer id) throws Exception {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isEmpty())
            throw  new Exception("Request for given user cannot be processed");
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
    public  List<User> getAll(){
        return userRepository.findAll();
    }


    @Override
    public List<User> searchUser(String query) {
        return userRepository.searchUser(query);
    }
}
