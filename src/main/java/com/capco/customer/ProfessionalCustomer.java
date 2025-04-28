package com.capco.customer;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProfessionalCustomer extends Customer {

    private final String companyName;
    private final String vatNumber;
    private final String companyDirectoryIdentificationSystem;
    private final Turnover turnover;

    private ProfessionalCustomer(UUID id,
                                 String companyName,
                                 String vatNumber,
                                 String companyDirectoryIdentificationSystem,
                                 Turnover turnover) {
        super(id);
        this.companyName = Objects.requireNonNull(companyName, "COMPANY NAME is mandatory");
        this.vatNumber = vatNumber;
        this.companyDirectoryIdentificationSystem = Objects.requireNonNull(companyDirectoryIdentificationSystem, "COMPANY DIRECTORY IDENTIFICATION SYSTEM is mandatory");
        this.turnover = Objects.requireNonNull(turnover, "TURNOVER is mandatory");
    }

    public static ProfessionalCustomer create(UUID id,
                                              String companyName,
                                              String vatNumber,
                                              String companyDirectoryIdentificationSystem,
                                              Turnover turnover) {
        return new ProfessionalCustomer(id, companyName, vatNumber, companyDirectoryIdentificationSystem, turnover);
    }

    public static ProfessionalCustomer create(UUID id,
                                              String companyName,
                                              String companyDirectoryIdentificationSystem,
                                              Turnover turnover) {
        return new ProfessionalCustomer(id, companyName, null, companyDirectoryIdentificationSystem, turnover);
    }

    public boolean hasHighTurnover() {
        return turnover.biggerThan(new Turnover(BigDecimal.valueOf(10_000_000), turnover.currency()));
    }
}
