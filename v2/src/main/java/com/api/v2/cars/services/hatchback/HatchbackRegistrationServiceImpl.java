package com.api.v2.cars.services.hatchback;

import com.api.v2.cars.domain.CarRepository;
import com.api.v2.cars.domain.Hatchback;
import com.api.v2.cars.dtos.CarResponseDto;
import com.api.v2.cars.services.abstracts.CarRegistrationService;
import com.api.v2.cars.utils.CarResponseMapperUtil;
import com.api.v2.vehicles.dtos.VehicleRegistrationRequestDto;
import com.api.v2.vehicles.services.VehicleRegistrationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HatchbackRegistrationServiceImpl extends CarRegistrationService {

    public HatchbackRegistrationServiceImpl(
            VehicleRegistrationService vehicleRegistrationService,
            CarRepository carRepository
    ) {
        super(vehicleRegistrationService, carRepository);
    }

    @Override
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return vehicleRegistrationService
                .register(requestDto)
                .flatMap(vehicle -> carRepository.save(Hatchback.of(vehicle)))
                .flatMap(CarResponseMapperUtil::mapToMono);
    }
}