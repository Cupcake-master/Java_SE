package ru.itis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specialist {
    private String name;
    private BigDecimal salary;
    private Specialty specialty;

    public Specialist(BigDecimal salary, Specialty specialty) {
        this.salary = salary;
        this.specialty = specialty;
    }
}
