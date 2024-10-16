package com.api.v1.cars.types.sedan;

import com.api.v1.cars.Car;
import com.api.v1.cars.domain.CarRepository;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.interfaces.CarRegistrationService;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class SedanRegistrationServiceImpl implements CarRegistrationService {

    @Autowired
    private VehicleRegistrationService vehicleRegistrationService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SedanResponseMapperUtil responseMapperUtil;

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(Sedan.of(vehicle))
                    .flatMap(sedan -> Mono.just(responseMapperUtil.map(sedan)))
                );
    }

}