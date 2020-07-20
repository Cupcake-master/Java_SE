package ru.itis.util;

import ru.itis.model.Specialist;
import ru.itis.model.Specialty;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiApproachUtil implements ApproachUtil{

    @Override
    public List<Specialist> findBySalaryLessThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream()
                .filter(specialist -> specialist.getSalary().compareTo(salary) < 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Specialist> findBySalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream()
                .filter(specialist -> specialist.getSalary().compareTo(salary) > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Specialist> findBySpecialty(List<Specialist> specialists, Specialty speciality) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpecialty().equals(speciality))
                .collect(Collectors.toList());
    }

    @Override
    public List<Specialist> findByName(List<Specialist> specialists, String name) {
        return specialists.stream()
                .filter(specialist -> specialist.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Specialist> sortBySalary(List<Specialist> specialists) {
        specialists.sort(Comparator.comparing(Specialist::getSalary));
        return specialists;
    }

    @Override
    public List<Specialist> sortByName(List<Specialist> specialists) {
        specialists.sort(Comparator.comparing(Specialist::getName));
        return specialists;
    }

    @Override
    public void consoleOutput(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
    }

    @Override
    public Map<String, Specialist> convertListToMap(List<Specialist> specialists){
        return specialists.stream()
                .collect(Collectors.toMap(
                        Specialist::getName,
                        specialist -> new Specialist(specialist.getSalary(), specialist.getSpecialty())
                ));
    }
}
