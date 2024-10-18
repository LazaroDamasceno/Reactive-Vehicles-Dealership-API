package com.api.v1.cars.services.elecrics;

import com.api.v1.cars.domain.repository.CarRepository;
import com.api.v1.cars.domain.subclasses.Electric;
import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.services.CarRegistrationService;
import com.api.v1.cars.utils.CarResponseMapperUtil;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v1.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ElectricRegistrationServiceImpl extends CarRegistrationService {

    public ElectricRegistrationServiceImpl(
            VehicleRegistrationService vehicleRegistrationService,
            CarRepository carRepository) {
        super(vehicleRegistrationService, carRepository);
    }

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(Electric.of(vehicle)))
                .flatMap(CarResponseMapperUtil::mapToMono);
    }

}