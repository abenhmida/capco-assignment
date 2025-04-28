package com.capco.customer;

import java.util.UUID;

public class PrivateCustomer extends Customer {

    private final String firstName;
    private final String lastName;

    private PrivateCustomer(UUID id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static PrivateCustomer create(UUID id, String firstName, String lastName) {
        return new PrivateCustomer(id, firstName, lastName);
    }
}
