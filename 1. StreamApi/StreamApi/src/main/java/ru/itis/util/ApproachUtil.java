package ru.itis.util;

import ru.itis.model.Specialist;
import ru.itis.model.Specialty;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ApproachUtil {
    List<Specialist> findBySalaryLessThen(List<Specialist> specialists, BigDecimal salary);
    List<Specialist> findBySalaryMoreThen(List<Specialist> specialists, BigDecimal salary);
    List<Specialist> findBySpecialty(List<Specialist> specialists, Specialty speciality);
    List<Specialist> findByName(List<Specialist> specialists, String name);
    List<Specialist> sortBySalary(List<Specialist> specialists);
    List<Specialist> sortByName(List<Specialist> specialists);
    void consoleOutput(List<Specialist> specialists);
    Map<String, Specialist> convertListToMap(List<Specialist> specialists);
}
