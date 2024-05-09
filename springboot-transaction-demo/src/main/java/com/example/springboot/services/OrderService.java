package com.example.springboot.services;

import com.example.springboot.dto.OrderRequest;
import com.example.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
