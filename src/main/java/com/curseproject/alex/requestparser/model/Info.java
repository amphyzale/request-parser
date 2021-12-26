package com.curseproject.alex.requestparser.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Info implements Serializable {

    private String info;
    private Double num;

}
