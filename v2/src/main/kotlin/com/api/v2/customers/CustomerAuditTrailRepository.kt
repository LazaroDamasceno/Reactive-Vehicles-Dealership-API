package com.api.v2.customers

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerAuditTrailRepository: CoroutineCrudRepository<CustomerAuditTrail, UUID>