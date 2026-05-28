package org.hospitalmanagementsystem.billingservice.service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public Double generateBill(String type) {

        if(type.equalsIgnoreCase("OPD")) {
            return 1000.0;
        }

        if(type.equalsIgnoreCase("IPD")) {
            return 10000.0;
        }

        if(type.equalsIgnoreCase("ICU")) {
            return 20000.0;
        }

        return 0.0;
    }
}
