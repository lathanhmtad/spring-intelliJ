package com.example.springboot.controller;

import com.example.springboot.dto.OrderRequest;
import com.example.springboot.dto.OrderResponse;
import com.example.springboot.repository.OrderRepository;
import com.example.springboot.services.OrderService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @PostMapping("")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
