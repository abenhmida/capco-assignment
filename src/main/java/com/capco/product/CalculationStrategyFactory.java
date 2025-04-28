package com.capco.product;

import com.capco.customer.Customer;
import com.capco.customer.PrivateCustomer;
import com.capco.customer.ProfessionalCustomer;

public final class CalculationStrategyFactory {

    public static PriceCalculationStrategy Create(Customer customer) {
        switch (customer) {
            case PrivateCustomer ignored -> {
                return new PrivateCustomerPriceCalculationStrategy();
            }
            case ProfessionalCustomer professionalCustomer -> {
                if (professionalCustomer.hasHighTurnover()) {
                    return new HighTurnoverEntreprisePriceCalculationStrategy();
                }
                return new LowTurnoverBusinessPriceCalculationStrategy();
            }
            default -> throw new IllegalStateException("Unexpected value: " + customer);
        }
    }
}
