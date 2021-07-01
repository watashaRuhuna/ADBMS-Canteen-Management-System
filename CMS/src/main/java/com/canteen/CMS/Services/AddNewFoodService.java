package com.canteen.CMS.Services;


import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Repository.AddNewFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddNewFoodService {
    @Autowired
    private AddNewFoodRepo addNewFoodRepo;
    public void addfoodtodb(AddNewFoodEntity addNewFoodEntity){


        addNewFoodRepo.save(addNewFoodEntity);
    }

    public List<AddNewFoodEntity> getAllFood(){

        return (List<AddNewFoodEntity>) addNewFoodRepo.findAll();
    }
}
