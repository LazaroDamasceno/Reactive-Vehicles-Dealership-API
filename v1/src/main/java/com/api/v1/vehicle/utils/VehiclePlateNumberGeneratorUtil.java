package com.api.v1.vehicle.utils;

import lombok.experimental.UtilityClass;
import java.util.*;

@UtilityClass
public class VehiclePlateNumberGeneratorUtil {


    private final int NUM_DIGITS = 7;
    private final int NUM_LETTERS = 3;
    private final Random random = new Random();
    private final Set<String> generatedPlateNumbers = new HashSet<>();

    public String generateUniquePlateNumber() {
        while (true) {
            String plateNumber = generateRandomPlateNumber();
            if (generatedPlateNumbers.add(plateNumber)) {
                return plateNumber;
            }
        }
    }

    private String generateRandomPlateNumber() {
        StringBuilder plateNumber = new StringBuilder();
        for (int i = 0; i < NUM_DIGITS; i++) {
            plateNumber.append(random.nextInt(10));
        }
        for (int i = 0; i < NUM_LETTERS; i++) {
            plateNumber.append((char) ('A' + random.nextInt(26)));
        }
        return plateNumber.toString();
    }

}
