package com.pharmaconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the order item

    @NonNull
    private String productCode;  // Unique code for the product

    @NonNull
    private String productName;  // Name of the product

    private int quantity;  // Quantity of the product ordered

    private double price;  // Price per unit of the product

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  // Reference to the Order this item belongs to

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
