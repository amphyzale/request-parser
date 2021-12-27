package com.curseproject.alex.requestparser.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Info implements Serializable {

    @Size(min=1)
    @NotBlank
    private String taskNumber;
    //1) Метод оценки и анализа проектов PERT
    @Min(0)
    @NotNull
    private Double optimisticGrade;
    @Min(0)
    @NotNull
    private Double pessimisticGrade;
    //2)Метод оценки вариантов использования UCP- Use Case Points
    @Min(0)
    @NotNull
    private Double timeForOneCase;
    @Min(0)
    @NotNull
    private Integer caseCount;
    @Min(0)
    @Max(5)
    @NotNull
    private Integer complexityCoefficient;
    @NotNull
    private Boolean isStandAvailable;
    @NotNull
    private Boolean isBackDone;
    @NotNull
    private Boolean isFrontDone;
    @NotNull
    private Boolean isAllTestersWorkFullDay;
    @NotNull
    private Boolean hasAutotests;
    //3) Метод оценки по функциональным точкам (FP) – function points
    @Min(0)
    @NotNull
    private Integer checkListTestCount;
    @NotEmpty
    private List<String> testPriority;
    @Min(0)
    @NotNull
    private Double timeForOneTest;

}
