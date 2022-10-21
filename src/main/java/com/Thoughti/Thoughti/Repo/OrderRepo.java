package com.Thoughti.Thoughti.Repo;

import com.Thoughti.Thoughti.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
