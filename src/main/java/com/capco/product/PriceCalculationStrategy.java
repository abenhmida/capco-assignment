package com.capco.product;

import java.math.BigDecimal;
import java.util.Map;

public interface PriceCalculationStrategy {

    default BigDecimal calculate(Basket basket){
        return basket.getProducts()
                .stream()
                .map(getPrices()::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    Map<Product, BigDecimal> getPrices();
}
