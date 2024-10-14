package com.pharmaconnect;
import com.pharmaconnect.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
    // Custom query methods (if needed)
}

