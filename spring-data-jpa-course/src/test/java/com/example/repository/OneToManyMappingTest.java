package com.example.repository;

import com.example.entity.Address;
import com.example.entity.Order;
import com.example.entity.OrderItem;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    // save order along with also save it's order item
    @Test
    void saveOrderMethod() {
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("In progress");

        // create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        order.getOrderItems().add(orderItem1);

        // create order item 1
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address= new Address();
        address.setCity("Pune");
        address.setStreet("Kothur");
        address.setState("Xu lu");
        address.setCountry("Viet nam");
        address.setZipCode("1424");

        order.setBillingAddress(address);
        address.setOrder(order);

        orderRepository.save(order);
    }

    @Test
    void fetchOrderMethod() {
        Order order = orderRepository.findById(1L).get();
        System.out.println(order.getStatus());
        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item.getProduct().getName());
        }
    }

    @Test
    void deleteOrderMethod() {
        orderRepository.deleteById(1L);
    }
}
