package com.api.v1.cars;

import com.api.v1.vehicles.utils.VehicleResponseMapperUtil;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class CarResponseMapperUtil {

    public CarResponseDto map(Car car) {
        return new CarResponseDto(
                car.getType(),
                car.getVin(),
                car.getPlateNumber(),
                VehicleResponseMapperUtil.map(car.getVehicle())
        );
    }

    public Mono<CarResponseDto> mapToMono(Car car) {
        return Mono.just(map(car));
    }

}
