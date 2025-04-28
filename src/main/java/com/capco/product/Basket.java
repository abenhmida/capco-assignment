package com.capco.product;

import com.capco.customer.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private final List<Product> products = new ArrayList<>();
    private final Customer customer;

    public Basket(Customer customer) {
        this.customer = Objects.requireNonNull(customer, "Customer should be provided");
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    public Customer getCustomer() {
        return customer;
    }
}
