package com.api.v1.cars.services;

import com.api.v1.cars.dtos.CarResponseDto;
import reactor.core.publisher.Flux;

public interface CarRetrievalService {

    Flux<CarResponseDto> findAll();

}
