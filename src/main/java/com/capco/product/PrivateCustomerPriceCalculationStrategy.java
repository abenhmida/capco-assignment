package com.capco.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PrivateCustomerPriceCalculationStrategy implements PriceCalculationStrategy {

    private final Map<Product, BigDecimal> priceByProduct = new HashMap<>();

    @Override
    public Map<Product, BigDecimal> getPrices() {

        priceByProduct.put(Product.HIGH_END_PHONE, BigDecimal.valueOf(1500));
        priceByProduct.put(Product.LOW_END_PHONE, BigDecimal.valueOf(800));
        priceByProduct.put(Product.LAPTOP, BigDecimal.valueOf(1200));

        return priceByProduct;
    }
}
