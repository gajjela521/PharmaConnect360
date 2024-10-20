package com.pharmaconnect.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmaconnect.OrderRepository;
import com.pharmaconnect.model.Order;
import com.pharmaconnect.model.OrderStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private AmazonSQS sqsClient;

    @Autowired
    private OrderRepository orderRepository;

    @Value("${cloud.aws.sqs.queue.url}")
    private String queueUrl;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void submitOrder(Order order) {
        orderRepository.save(order);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            queueMessagingTemplate.send(queueUrl, MessageBuilder.withPayload(orderJson).build());
            logger.info("Order submitted and sent to SQS. Order ID: {}", order.getId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting order to JSON", e);
        }
    }

    public String updateOrderStatus(Long id, OrderStatus orderStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // Update the order's status
        order.setStatus(orderStatus);
        orderRepository.save(order);

        String updateMessage = String.format("Order with ID %d updated to status: %s", id, orderStatus);
        logger.info(updateMessage);

        // Return the status message
        return updateMessage;
    }
}
