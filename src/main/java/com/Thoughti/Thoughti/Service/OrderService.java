package com.Thoughti.Thoughti.Service;

import com.Thoughti.Thoughti.Entity.Order;
import com.Thoughti.Thoughti.Exception.ResourceNotFoundException;
import com.Thoughti.Thoughti.Repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService  {
    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(Order order) {
        return this.orderRepo.save(order);
    }



    public Order getOrderById(Integer id) {
        return this.orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
    }

    public List<Order> getAllOrder() {
        return this.orderRepo.findAll();
    }
}
