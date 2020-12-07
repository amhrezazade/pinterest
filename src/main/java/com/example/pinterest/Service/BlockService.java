package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Block;
import com.example.pinterest.Model.BlockModel;
import com.example.pinterest.Repository.IRepositoryBlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService 
{
    @Autowired
    private IRepositoryBlock BlockRepository;

      public List<BlockModel> getAllBlocks()
      {
        List<Block> blocks = BlockRepository.findAll();
        ArrayList<BlockModel> Result = new ArrayList<>();
        for (Block block:(List<Block>)blocks)
        {
            Result.add(new BlockModel(block));
        }
        return Result;
      }
      
}