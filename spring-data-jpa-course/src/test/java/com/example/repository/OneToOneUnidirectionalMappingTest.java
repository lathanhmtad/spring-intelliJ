package com.example.repository;

import com.example.entity.Address;
import com.example.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(150000));

        Address address= new Address();
        address.setCity("Pune");
        address.setStreet("Kothur");
        address.setState("Xu lu");
        address.setCountry("Viet nam");
        address.setZipCode("1424");

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void updateOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");

        order.getBillingAddress().setZipCode("5000");
        order.getBillingAddress().setStreet("Hoa Lien");

        orderRepository.save(order);
    }

    @Test
    void deleteOrderMethod() {
        orderRepository.deleteById(1L);
    }


    @Test
    void getOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        System.out.println(order);
    }
}
