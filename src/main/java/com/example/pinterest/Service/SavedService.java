package com.example.pinterest.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.pinterest.Entity.Saved;
import com.example.pinterest.Model.SavedModel;
import com.example.pinterest.Repository.IRepositorySaved;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavedService 
{
    @Autowired
    private IRepositorySaved SavedRepository;

      public List<SavedModel> getAllSaveds()
      {
        List<Saved> saveds = SavedRepository.findAll();
        ArrayList<SavedModel> Result = new ArrayList<>();
        for (Saved saved:(List<Saved>)saveds)
        {
            Result.add(new SavedModel(saved));
        }
        return Result;
      }
      
}