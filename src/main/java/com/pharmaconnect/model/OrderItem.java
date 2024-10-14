package com.pharmaconnect.model;

import org.springframework.lang.NonNull;

public class OrderItem {

    @NonNull
    private String productCode;  // Unique code for the product
    @NonNull
    private String productName;   // Name of the product
    private int quantity;         // Quantity of the product ordered
    private double price;       // Price per unit of the product

    @NonNull
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(@NonNull String productCode) {
        this.productCode = productCode;
    }

    @NonNull
    public String getProductName() {
        return productName;
    }

    public void setProductName(@NonNull String productName) {
        this.productName = productName;
    }

    @NonNull
    public int getQuantity() {
        return quantity;
    }
    @NonNull
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @NonNull
    public double getPrice() {
        return price;
    }
    @NonNull
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
