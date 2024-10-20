package com.pharmaconnect.lambda;

import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmaconnect.Service.OrderService;
import com.pharmaconnect.model.Order;
import com.pharmaconnect.model.OrderStatus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessingLambda implements RequestHandler<SQSEvent, String> {

    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingLambda.class);

    @Autowired
    private OrderService orderService;

    @Override
    public String handleRequest(SQSEvent event, Context context) {
        StringBuilder response = new StringBuilder();
        for (SQSEvent.SQSMessage message : event.getRecords()) {
            String orderResponse = processOrder(message.getBody());
            response.append(orderResponse).append("\n");
        }
        return response.toString();
    }

    private String processOrder(String orderJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Order order = objectMapper.readValue(orderJson, Order.class);
            // Process the order and update the status
            String statusMessage = orderService.updateOrderStatus(order.getId(), OrderStatus.PROCESSING);
            logger.info(statusMessage);  // Log the update
            return statusMessage;
        } catch (JsonProcessingException e) {
            String errorMessage = "Error processing order JSON";
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}
