package com.canteen.CMS.Services;

import com.canteen.CMS.Entity.OrderEntity;
import com.canteen.CMS.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public void addOrder(OrderEntity orderEntity){

        orderRepo.save(orderEntity);

    }
}
