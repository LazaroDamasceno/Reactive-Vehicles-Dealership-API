package com.api.v2.customers.utils

import com.api.v2.customers.domain.Customer
import com.api.v2.customers.dtos.CustomerResponseDto
import com.api.v2.persons.PersonResponseMapper

class CustomerResponseMapper {

    companion object {
        fun map(customer: Customer): CustomerResponseDto {
            return CustomerResponseDto(
                customer.isActive,
                PersonResponseMapper.map(customer.person)
            )
        }
    }

}