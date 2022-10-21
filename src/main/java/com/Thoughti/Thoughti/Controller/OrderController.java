package com.Thoughti.Thoughti.Controller;

import com.Thoughti.Thoughti.Entity.Order;
import com.Thoughti.Thoughti.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("order/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){

        Order o=this.orderService.createOrder(order);
        return  new ResponseEntity<>(o, HttpStatus.CREATED);

    }

    @GetMapping("order/{order_id}")
    public ResponseEntity<Order> getUser(@PathVariable("order_Id") Integer id){
        Order o=this.orderService.getOrderById(id);
        return  ResponseEntity.ok(o);
    }

    @GetMapping("order")
    public ResponseEntity<List<Order>> getAllUsers(){
        return ResponseEntity.ok(this.orderService.getAllOrder());
    }




}
