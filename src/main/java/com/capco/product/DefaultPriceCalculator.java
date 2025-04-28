package com.capco.product;

import java.math.BigDecimal;

public class DefaultPriceCalculator implements PriceCalculator {

    @Override
    public BigDecimal calculate(Basket basket) {
        PriceCalculationStrategy calculationStrategy = CalculationStrategyFactory.Create(basket.getCustomer());
        return calculationStrategy.calculate(basket);
    }
}
