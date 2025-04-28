package com.capco.product;

import java.math.BigDecimal;

public interface PriceCalculator {
    BigDecimal calculate(Basket basket);
}
