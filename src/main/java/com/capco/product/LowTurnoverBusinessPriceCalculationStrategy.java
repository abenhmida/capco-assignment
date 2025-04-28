package com.capco.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class LowTurnoverBusinessPriceCalculationStrategy implements PriceCalculationStrategy {

    private final Map<Product, BigDecimal> priceByProduct = new HashMap<>();

    @Override
    public Map<Product, BigDecimal> getPrices() {

        priceByProduct.put(Product.HIGH_END_PHONE, BigDecimal.valueOf(1150));
        priceByProduct.put(Product.LOW_END_PHONE, BigDecimal.valueOf(600));
        priceByProduct.put(Product.LAPTOP, BigDecimal.valueOf(1000));

        return priceByProduct;
    }
}
