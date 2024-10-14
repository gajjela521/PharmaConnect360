package com.pharmaconnect.controller;

import com.pharmaconnect.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    public ResponseEntity<String> createOrder(@RequestBody Order order){

        return ResponseEntity.ok("Order Created");
    }
}
