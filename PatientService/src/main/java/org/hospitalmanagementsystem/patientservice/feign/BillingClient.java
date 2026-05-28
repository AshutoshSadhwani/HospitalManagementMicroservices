package org.hospitalmanagementsystem.patientservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="BILLINGSERVICE")
public interface BillingClient {

    @GetMapping("/billing/{type}")
    Double getBill(
            @PathVariable String type
    );
}