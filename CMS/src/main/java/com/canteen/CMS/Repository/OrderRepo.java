package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.OrderEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<OrderEntity,Integer> {

    @Query(value = "SELECT u FROM OrderEntity u where u.food_type = 'Breakfirst'")
    List<OrderEntity> getBreakFirst();

    @Query(value = "SELECT u FROM OrderEntity u where u.food_type = 'Lunch'")
    List<OrderEntity> getLunch();

    @Query(value = "SELECT u FROM OrderEntity u where u.food_type = 'Dinner'")
    List<OrderEntity> getDinner();

    @Query(value = "{call  order_history(:u_id)}",nativeQuery = true)
    List<OrderEntity> order_history(Integer u_id);

    @Modifying
    @Query(value = "{call  order_cancel(:order_id)}",nativeQuery = true)
    @Transactional
    void order_cancel(Integer order_id);

    @Modifying
    @Query(value = "{call  order_issue(:order_id)}",nativeQuery = true) //call to stored procedure
    @Transactional
    void order_issue(Integer order_id);
}
