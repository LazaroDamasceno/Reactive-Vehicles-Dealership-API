package com.api.v1.customers.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Document(collection = "customer_audit_trail")
public record CustomerAuditTrail(
        @Id
        UUID id,
        Customer customer,
        LocalDateTime createdAt,
        ZoneId createdAtZone
) {

    public static CustomerAuditTrail of(Customer customer) {
        return new CustomerAuditTrail(
                UUID.randomUUID(),
                customer,
                LocalDateTime.now(),
                ZoneId.systemDefault()
        );
    }

}
