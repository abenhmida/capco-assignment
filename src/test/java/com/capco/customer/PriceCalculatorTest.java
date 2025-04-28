package com.capco.customer;

import com.capco.product.Basket;
import com.capco.product.DefaultPriceCalculator;
import com.capco.product.PriceCalculator;
import com.capco.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public class PriceCalculatorTest {

    private final PriceCalculator sut = new DefaultPriceCalculator();

    @Test
    @DisplayName("should calculate products price for a private customer")
    void testCalculatePrice() {
        PrivateCustomer customer = PrivateCustomer.create(UUID.randomUUID(),
                "John", "doe");

        Basket basket = new Basket(customer);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LAPTOP);

        BigDecimal expected = BigDecimal.valueOf(5000);

        BigDecimal actual = sut.calculate(basket);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should calculate products price for a professional customer with 11_000_000 turnover")
    void testCalculatePriceHighTurnoverCompany() {
        ProfessionalCustomer customer = ProfessionalCustomer.create(
                UUID.randomUUID(), "zarda",
                "2336459",
                "128887656",
                new Turnover(BigDecimal.valueOf(11_000_000), Currency.getInstance("USD")));

        Basket basket = new Basket(customer);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LAPTOP);

        BigDecimal expected = BigDecimal.valueOf(4550);

        BigDecimal actual = sut.calculate(basket);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should calculate products price for a professional customer with 1_000_000 turnover")
    void testCalculatePriceLowTurnoverCompany() {
        ProfessionalCustomer customer = ProfessionalCustomer.create(
                UUID.randomUUID(),
                "spaceX",
                "7852121042",
                new Turnover(BigDecimal.valueOf(1_000_000), Currency.getInstance("USD")));

        Basket basket = new Basket(customer);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.LOW_END_PHONE);
        basket.add(Product.HIGH_END_PHONE);
        basket.add(Product.LAPTOP);

        BigDecimal expected = BigDecimal.valueOf(5100);

        BigDecimal actual = sut.calculate(basket);
        Assertions.assertEquals(expected, actual);
    }
}
