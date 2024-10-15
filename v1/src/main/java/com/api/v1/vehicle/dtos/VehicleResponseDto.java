package com.api.v1.vehicle.dtos;

import java.time.ZonedDateTime;

public record VehicleResponseDto(
        String model,
        String make,
        int manufacturingYear,
        String vin,
        ZonedDateTime createdAt
) {
}
