package com.pharmaconnect.controller;

import com.pharmaconnect.model.Order;
import com.pharmaconnect.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value( "${cloud.aws.end-point.uri}")
    private String endpoint;

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        logger.info("Received request to create order: {}", order);
        orderService.submitOrder(order);
        logger.info("Order created successfully: {}", order.getId());
        return ResponseEntity.ok("Order Created");
    }


    @GetMapping("/send/{message}")
    public void sendMessageToQueue(@PathVariable String message) {
        logger.info("Sending message to queue: {}", message);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
        logger.info("Message sent successfully");
    }
}
