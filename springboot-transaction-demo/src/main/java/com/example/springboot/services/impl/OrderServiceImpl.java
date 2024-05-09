package com.example.springboot.services.impl;

import com.example.springboot.dto.OrderRequest;
import com.example.springboot.dto.OrderResponse;
import com.example.springboot.entity.Order;
import com.example.springboot.entity.Payment;
import com.example.springboot.execption.PaymentException;
import com.example.springboot.repository.OrderRepository;
import com.example.springboot.repository.PaymentRepository;
import com.example.springboot.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("IN_PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;

    }
}
