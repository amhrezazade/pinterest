package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.User;
import com.example.pinterest.Model.UserModel;
import com.example.pinterest.Repository.IRepositoryUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
    @Autowired
    private IRepositoryUser UserRepository;

      public List<UserModel> getAllUsers()
      {
        List<User> users = UserRepository.findAll();
        ArrayList<UserModel> Result = new ArrayList<>();
        for (User user:(List<User>)users)
        {
            Result.add(new UserModel(user));
        }
        return Result;
      }
      
}