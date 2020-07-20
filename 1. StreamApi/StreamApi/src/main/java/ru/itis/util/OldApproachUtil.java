package ru.itis.util;

import ru.itis.model.Specialist;
import ru.itis.model.Specialty;

import java.math.BigDecimal;
import java.util.*;

public class OldApproachUtil implements ApproachUtil{

    @Override
    public List<Specialist> findBySalaryLessThen(List<Specialist> specialists, BigDecimal salary) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist specialist: specialists) {
            if (specialist.getSalary().compareTo(salary) < 0){
                result.add(specialist);
            }
        }
        return result;
    }

    @Override
    public List<Specialist> findBySalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist specialist: specialists) {
            if (specialist.getSalary().compareTo(salary) > 0){
                result.add(specialist);
            }
        }
        return result;
    }

    @Override
    public List<Specialist> findBySpecialty(List<Specialist> specialists, Specialty speciality) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist specialist: specialists) {
            if (specialist.getSpecialty().equals(speciality)){
                result.add(specialist);
            }
        }
        return result;
    }

    @Override
    public List<Specialist> findByName(List<Specialist> specialists, String name) {
        List<Specialist> result = new ArrayList<>();
        for (Specialist specialist: specialists) {
            if (specialist.getName().equals(name)){
                result.add(specialist);
            }
        }
        return result;
    }

    @Override
    public List<Specialist> sortBySalary(List<Specialist> specialists) {
        specialists.sort(new Comparator<>() {
            @Override
            public int compare(Specialist o1, Specialist o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });
        return specialists;
    }

    @Override
    public List<Specialist> sortByName(List<Specialist> specialists) {
        specialists.sort(new Comparator<>() {
            @Override
            public int compare(Specialist o1, Specialist o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return specialists;
    }

    @Override
    public void consoleOutput(List<Specialist> specialists) {
        for (Specialist specialist: specialists) {
            System.out.print(specialist + " ");
        }
    }

    @Override
    public Map<String, Specialist> convertListToMap(List<Specialist> specialists) {
        Map<String, Specialist> result = new HashMap<>();
        for (Specialist specialist: specialists) {
            result.put(specialist.getName(), new Specialist(specialist.getSalary(), specialist.getSpecialty()));
        }
        return result;
    }
}
