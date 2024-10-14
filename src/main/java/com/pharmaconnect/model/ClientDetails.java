package com.pharmaconnect.model;

/*
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
*/

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

public class ClientDetails {

    @Id
    @NonNull
    private Long id;  // Unique identifier for the client
    @NonNull
    private String name;  // Client's name
    @NonNull
    private String primaryEmail;  // Primary email address
    private String secondaryEmail;  // Secondary email address
    @NonNull
    private String primaryMobile;  // Primary mobile number
    private String secondaryMobile;  // Secondary mobile number



    public @NonNull Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public @NonNull String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(@NonNull String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public @NonNull String getPrimaryMobile() {
        return primaryMobile;
    }

    public void setPrimaryMobile(@NonNull String primaryMobile) {
        this.primaryMobile = primaryMobile;
    }

    public String getSecondaryMobile() {
        return secondaryMobile;
    }

    public void setSecondaryMobile(String secondaryMobile) {
        this.secondaryMobile = secondaryMobile;
    }



}
