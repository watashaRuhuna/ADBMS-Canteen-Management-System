package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepo extends CrudRepository<AddNewFoodEntity,Integer> {


}
