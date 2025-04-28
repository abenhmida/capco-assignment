package com.capco.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;


class TurnoverTest {

    @Test
    @DisplayName("should return true if turnover is bigger that the value entered as parameter")
    void testBiggerThanShouldReturnTrue() {
        Turnover input = new Turnover(BigDecimal.valueOf(9_000_000), Currency.getInstance("EUR"));
        Turnover sut = new Turnover(BigDecimal.valueOf(10_000_000), Currency.getInstance("EUR"));

        Assertions.assertTrue(sut.biggerThan(input));
    }

    @Test
    @DisplayName("should throw an error if value is negative")
    void testBiggerThanShouldThrow() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Turnover(BigDecimal.valueOf(-9_000_000), Currency.getInstance("EUR"));
        });
    }

}