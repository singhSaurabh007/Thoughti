package com.Thoughti.Thoughti;


import com.Thoughti.Thoughti.Entity.Order;
import com.Thoughti.Thoughti.Exception.ResourceNotFoundException;
import com.Thoughti.Thoughti.Repo.OrderRepo;
import com.Thoughti.Thoughti.Service.OrderService;
import org.apache.tomcat.util.descriptor.web.FragmentJarScannerCallback;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
class ThoughtiApplicationTests {

	@Mock
	OrderRepo orderRepo;

	@InjectMocks
	OrderService orderService;

	Order order;
	@BeforeEach
	public void setup(){
		order= Order.builder().id(1).date(new Date(21/10/2022)).orderStatus("Success").items(new ArrayList<>()).build();
	}


	@DisplayName("Junit test for createOrder method on service class")
	@Test
	void createOrderTest() {
		//given(orderRepo.findById(order.getId());
		given(orderRepo.save(order)).willReturn(order);

		Order createdOrder=orderService.createOrder(order);
		assertThat(createdOrder).isNotNull();
		assertEquals(createdOrder,order);


	}

	@DisplayName("JUnit test for getAllOrder method")
	@Test
	void getAllOrderTest(){
		Order order1= Order.builder().id(2).date(new Date(20/10/2022)).orderStatus("Success").items(new ArrayList<>()).build();
		given(orderRepo.findAll()).willReturn(List.of(order,order1));
		List<Order> list=orderService.getAllOrder();
		assertThat(list).isNotNull();
		assertThat(list.size()).isEqualTo(2);
	}


	@DisplayName("JUnit test for getOrderById method")
	@Test
	void getOrderByIdTest(){
		given(orderRepo.findById(1)).willReturn(Optional.of(order));
		Order result=orderService.getOrderById(order.getId());
		assertThat(result.getId()).isEqualTo(1);
	}














}
