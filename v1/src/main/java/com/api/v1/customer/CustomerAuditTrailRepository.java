package com.api.v1.customer;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CustomerAuditTrailRepository extends ReactiveMongoRepository<CustomerAuditTrail, UUID> {
}