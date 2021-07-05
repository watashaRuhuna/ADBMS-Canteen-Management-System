package com.canteen.CMS.Repository;

import com.canteen.CMS.Entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<OrderEntity,Integer> {
}
