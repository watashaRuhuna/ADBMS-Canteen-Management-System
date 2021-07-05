package com.canteen.CMS.Services;

import com.canteen.CMS.Entity.AddNewFoodEntity;
import com.canteen.CMS.Entity.OrderEntity;
import com.canteen.CMS.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public void addOrder(OrderEntity orderEntity){

        orderRepo.save(orderEntity);

    }
    public List<OrderEntity> breakfirstOrders(){

        return (List<OrderEntity>) orderRepo.getBreakFirst();
    }
    public List<OrderEntity> lunchOrders(){

        return (List<OrderEntity>) orderRepo.getLunch();
    }
    public List<OrderEntity> dinnerOrders(){

        return (List<OrderEntity>) orderRepo.getDinner();
    }
}