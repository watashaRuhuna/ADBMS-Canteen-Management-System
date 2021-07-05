package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<OrderEntity,Integer> {

    @Query(value = "SELECT u FROM OrderEntity u where 'food_type' = 'Breakfirst'")
    List<OrderEntity> getBreakFirst();

    @Query(value = "SELECT u FROM OrderEntity u where 'food_type' = 'Lunch'")
    List<OrderEntity> getLunch();

    @Query(value = "SELECT u FROM OrderEntity u where 'food_type' = 'Dinner'")
    List<OrderEntity> getDinner();


}
