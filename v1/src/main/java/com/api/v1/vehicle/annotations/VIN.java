package com.api.v1.vehicle.annotations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 13, max = 13)
public @interface VIN {
    String message() default "Invalid VIN format. Please enter a 13-digit Vehicle Identification Number.";
}