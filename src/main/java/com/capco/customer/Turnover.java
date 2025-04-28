package com.capco.customer;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record Turnover(BigDecimal value, Currency currency) {
    public Turnover {
        Objects.requireNonNull(value, "VALUE must not be empty");
        if (value.longValue() < 0) {
            throw new IllegalArgumentException("VALUE must be positive");
        }
    }

    public boolean biggerThan(Turnover turnover) {
        if (!Objects.equals(currency.getCurrencyCode(), turnover.currency.getCurrencyCode())) {
            throw new RuntimeException("Values are not comparable");
        }
        return value.compareTo(turnover.value) > 0;
    }
}
