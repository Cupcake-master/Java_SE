package ru.itis.util;

import org.junit.jupiter.api.Test;
import ru.itis.model.Specialist;
import ru.itis.model.Specialty;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ApproachUtilTest {

    private OldApproachUtil oldApproachUtil;
    private StreamApiApproachUtil streamApiApproachUtil;

    private List<ApproachUtil> approachUtils = asList(getOldApproachUtil(), getStreamApiApproachUtil());

    private List<Specialist> result = asList(
            new Specialist("F", new BigDecimal(1000), Specialty.ENGINEER),
            new Specialist("E", new BigDecimal(2000), Specialty.ENGINEER),
            new Specialist("D", new BigDecimal(3000), Specialty.DEVOPS),
            new Specialist("C", new BigDecimal(4000), Specialty.DEVOPS),
            new Specialist("B", new BigDecimal(5000), Specialty.MANAGER),
            new Specialist("A", new BigDecimal(6000), Specialty.MANAGER));

    private OldApproachUtil getOldApproachUtil() {
        return Objects.requireNonNullElseGet(oldApproachUtil, OldApproachUtil::new);
    }

    private StreamApiApproachUtil getStreamApiApproachUtil(){
        return Objects.requireNonNullElseGet(streamApiApproachUtil, StreamApiApproachUtil::new);
    }

    @Test
    void findBySalaryLessThen() {
        approachUtils.forEach(x -> assertArrayEquals(x.findBySalaryLessThen(result, new BigDecimal(4000)).toArray(),
                result.subList(0, 3).toArray()));
    }

    @Test
    void findBySalaryMoreThen() {
        approachUtils.forEach(x -> assertArrayEquals(x.findBySalaryMoreThen(result, new BigDecimal(3999)).toArray(),
                result.subList(3, 6).toArray()));
    }

    @Test
    void findBySpecialty() {
        approachUtils.forEach(x -> assertArrayEquals(x.findBySpecialty(result, Specialty.ENGINEER).toArray(),
                result.subList(0, 2).toArray()));
    }

    @Test
    void findByName() {
        approachUtils.forEach(x -> assertArrayEquals(x.findByName(result, "C").toArray(),
                Collections.singletonList(result.get(3)).toArray()));
    }

    @Test
    void sortBySalary() {
        approachUtils.forEach(x -> assertArrayEquals(x.sortBySalary(result).toArray(),
                result.subList(0, 6).toArray()));
    }

    @Test
    void sortByName() {
        Collections.reverse(result);
        approachUtils.forEach(x -> assertArrayEquals(x.sortByName(result).toArray(),
                result.toArray()));
    }

    @Test
    void consoleOutput() {
        approachUtils.forEach(x -> x.consoleOutput(result));
    }

    @Test
    void convertListToMap() {
        Collections.reverse(result);
        approachUtils.forEach(x -> assertArrayEquals(x.convertListToMap(result).keySet().toArray(),
                result.stream().map(Specialist::getName).collect(Collectors.toList()).toArray()));
        List<Specialist> specialists = new ArrayList<>();
        getOldApproachUtil().convertListToMap(result).forEach((key, value) -> specialists.add(value));
        Collections.reverse(specialists);
        approachUtils.forEach(y -> assertArrayEquals(specialists.toArray(), Arrays.asList(
                new Specialist(new BigDecimal(1000), Specialty.ENGINEER),
                new Specialist(new BigDecimal(2000), Specialty.ENGINEER),
                new Specialist(new BigDecimal(3000), Specialty.DEVOPS),
                new Specialist(new BigDecimal(4000), Specialty.DEVOPS),
                new Specialist(new BigDecimal(5000), Specialty.MANAGER),
                new Specialist(new BigDecimal(6000), Specialty.MANAGER)).toArray()));

    }
}