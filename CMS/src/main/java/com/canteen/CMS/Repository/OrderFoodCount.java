package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.OrderCountAndName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodCount extends CrudRepository<OrderCountAndName, Integer> {


}
