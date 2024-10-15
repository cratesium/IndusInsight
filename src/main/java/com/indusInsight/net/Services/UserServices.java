package com.indusInsight.net.Services;

import com.indusInsight.net.model.User;

import java.util.List;

public interface UserServices {

    public User registerUser(User user);
    public User findUserById(Integer id) throws Exception;
    public User findUserByEmail(String email) throws Exception;
    public  User followUser(Integer id1 ,Integer id2) throws  Exception;
    public User updateUser(User user,Integer id) throws Exception;
    public List<User>searchUser(String query);

    List<User> getAll();
}
