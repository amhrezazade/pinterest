package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Post;
import com.example.pinterest.Model.PostModel;
import com.example.pinterest.Repository.IRepositoryPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService 
{
    @Autowired
    private IRepositoryPost PostRepository;

      public List<PostModel> getAllPosts()
      {
        List<Post> posts = PostRepository.findAll();
        ArrayList<PostModel> Result = new ArrayList<>();
        for (Post post:(List<Post>)posts)
        {
            Result.add(new PostModel(post));
        }
        return Result;
      }
      
}