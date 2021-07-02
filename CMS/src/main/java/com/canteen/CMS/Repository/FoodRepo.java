package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepo extends CrudRepository<AddNewFoodEntity,Integer> {

    @Query(value = "SELECT u FROM AddNewFoodEntity u")
    List<AddNewFoodEntity>  getCount();

}
