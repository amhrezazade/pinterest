package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Like;
import com.example.pinterest.Model.LikeModel;
import com.example.pinterest.Repository.IRepositoryLike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService 
{
    @Autowired
    private IRepositoryLike LikeRepository;

      public List<LikeModel> getAllLikes()
      {
        List<Like> likes = LikeRepository.findAll();
        ArrayList<LikeModel> Result = new ArrayList<>();
        for (Like like:(List<Like>)likes)
        {
            Result.add(new LikeModel(like));
        }
        return Result;
      }
      
}