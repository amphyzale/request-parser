package com.curseproject.alex.requestparser.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Info implements Serializable {
    private String taskNumber;
    //1) Метод оценки и анализа проектов PERT
    private Double optimisticGrade;
    private Double pessimisticGrade;
    //2)Метод оценки вариантов использования UCP- Use Case Points
    private Double timeForOneCase;
    private Integer caseCount;
    private Integer complexityCoefficient;
    private Boolean isStandAvailable;
    private Boolean isBackDone;
    private Boolean isFrontDone;
    private Boolean isAllTestersWorkFullDay;
    private Boolean hasAutotests;
    //3) Метод оценки по функциональным точкам (FP) – function points
    private Integer checkListTestCount;
    private List<String> testPriority;
    private Double timeForOneTest;

}
