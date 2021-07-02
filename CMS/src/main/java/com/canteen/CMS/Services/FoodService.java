package com.canteen.CMS.Services;


import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;
    public void addfoodtodb(AddNewFoodEntity addNewFoodEntity){


        foodRepo.save(addNewFoodEntity);
    }

    public List<AddNewFoodEntity> getAllFood(){

        return (List<AddNewFoodEntity>) foodRepo.findAll();
    }


}
