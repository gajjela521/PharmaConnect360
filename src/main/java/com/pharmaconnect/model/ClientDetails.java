package com.pharmaconnect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;

@Entity
@Table(name = "client_details")
@Getter
@Setter
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the client

    @NonNull
    @Column(nullable = false)

    private String name;  // Client's name

    @NonNull
    @Column(nullable = false)

    private String primaryEmail;  // Primary email address

    private String secondaryEmail;  // Secondary email address

    @NonNull
    @Column(nullable = false)

    private String primaryMobile;  // Primary mobile number

    private String secondaryMobile;  // Secondary mobile number

    @Override
    public String toString() {
        return "ClientDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", primaryEmail='" + primaryEmail + '\'' +
                ", secondaryEmail='" + secondaryEmail + '\'' +
                ", primaryMobile='" + primaryMobile + '\'' +
                ", secondaryMobile='" + secondaryMobile + '\'' +
                '}';
    }
}
