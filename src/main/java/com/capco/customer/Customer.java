package com.capco.customer;

import java.util.Objects;
import java.util.UUID;

public abstract class Customer {
    
    private final UUID id;

    protected Customer(UUID id) {
        this.id = Objects.requireNonNull(id, "ID is mandatory");;
    }
}
