package ru.itis;

import ru.itis.model.Specialist;
import ru.itis.model.Specialty;
import ru.itis.util.ApproachUtil;
import ru.itis.util.OldApproachUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Specialist> result = new ArrayList<>();
        result.add(new Specialist("Ivan Ivanov", new BigDecimal(5000), Specialty.ENGINEER));
        result.add(new Specialist("Alexander Alexandrov", new BigDecimal(4000), Specialty.ENGINEER));
        result.add(new Specialist("Sergey Sergeev", new BigDecimal(3000), Specialty.DEVOPS));
        result.add(new Specialist("Fedor Fedorov", new BigDecimal(2000), Specialty.DEVOPS));
        result.add(new Specialist("Kirill Kirillov", new BigDecimal(10000), Specialty.MANAGER));
        result.add(new Specialist("Petr Petrov", new BigDecimal(10000), Specialty.MANAGER));

        ApproachUtil approachUtil = new OldApproachUtil();
//        System.out.println(approachUtil.findBySalaryLessThen(result, new BigDecimal(5002)));
//        System.out.println(approachUtil.findBySalaryMoreThen(result, new BigDecimal(5002)));
//        System.out.println(approachUtil.findBySpecialty(result, Specialty.ENGINEER));
//        System.out.println(approachUtil.findByName(result, "Ivan Ivanov"));
//        System.out.println(approachUtil.sortBySalary(result));
//        System.out.println(approachUtil.sortByName(result));
//        approachUtil.consoleOutput(result);
        System.out.println(approachUtil.convertListToMap(result));
    }
}
