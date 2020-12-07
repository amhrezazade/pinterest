package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Follow;
import com.example.pinterest.Model.FollowModel;
import com.example.pinterest.Repository.IRepositoryFollow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService 
{
    @Autowired
    private IRepositoryFollow FollowRepository;

      public List<FollowModel> getAllFollows()
      {
        List<Follow> follows = FollowRepository.findAll();
        ArrayList<FollowModel> Result = new ArrayList<>();
        for (Follow follow:(List<Follow>)follows)
        {
            Result.add(new FollowModel(follow));
        }
        return Result;
      }
      
}