package com.canteen.CMS.Services;
import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OwnerEntity;
import com.canteen.CMS.Repository.FoodRepo;
import com.canteen.CMS.Repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private FoodRepo foodRepo;

    public OwnerEntity ownerLogin(String email, String pwd){

        OwnerEntity ownerEntity= ownerRepo.findAllByEmailAndPassword(email,pwd);
//        OwnerEntity ownerEntity= (OwnerEntity) ownerRepo.findAll();

        return  ownerEntity;

    }

    public boolean updateFood(Integer id, float price, Integer qty){
        AddNewFoodEntity updatefoodobj=foodRepo.findById(id).get();
        if(foodRepo.findById(id).isPresent()){
            updatefoodobj.setUnit_price(price);
            updatefoodobj.setFood_qty(qty);
            foodRepo.save(updatefoodobj);
            return true;
        }else{
            return false;
        }

    }

}
