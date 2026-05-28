package org.hospitalmanagementsystem.billingservice.controller;

import org.hospitalmanagementsystem.billingservice.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @GetMapping("/{type}")
    public Double generateBill(
            @PathVariable String type
    ) {

        return service.generateBill(type);
    }
}