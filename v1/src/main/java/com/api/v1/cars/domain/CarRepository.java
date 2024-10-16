package com.api.v1.cars.domain;

import com.api.v1.cars.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {
}
