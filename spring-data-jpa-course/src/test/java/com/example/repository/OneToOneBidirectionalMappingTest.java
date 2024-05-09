package com.example.repository;

import com.example.entity.Address;
import com.example.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneBidirectionalMappingTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    void saveAddressMethod() {
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
        address.setOrder(order);

        addressRepository.save(address);
    }

    @Test
    void updateAddressMethod() {
        Address address = addressRepository.findById(1L).get();
        address.setZipCode("5000");
        address.setCountry("Thai Lan");

        address.getOrder().setStatus("DELIVERED");
        address.getOrder().setTotalPrice(new BigDecimal(200000));

        addressRepository.save(address);
    }

    @Test
    void fetchAddressMethod() {
        Address address = addressRepository.findById(1L).get();
        System.out.println(address);
    }

    @Test
    void deleteAddressMethod() {
        addressRepository.deleteById(1L);
    }

}
