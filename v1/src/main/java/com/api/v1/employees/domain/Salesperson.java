package com.api.v1.employees.domain;

import com.api.v1.persons.domain.Person;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Salesperson extends Employee {

    private Salesperson(Person person) {
        super("Salesperson", person);
    }

    public static Salesperson of(Person person) {
        return new Salesperson(person);
    }

}
