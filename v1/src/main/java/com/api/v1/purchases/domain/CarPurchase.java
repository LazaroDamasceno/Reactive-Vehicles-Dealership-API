package com.api.v1.purchases.domain;

import com.api.v1.cars.domain.Car;
import com.api.v1.customers.domain.Customer;
import com.api.v1.employees.domain.Salesperson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document
public class CarPurchase extends Purchase {

    private Car car;

    public CarPurchase(Customer customer, Salesperson salesperson, Car car) {
        super(customer, salesperson);
        this.car = car;
    }

}
