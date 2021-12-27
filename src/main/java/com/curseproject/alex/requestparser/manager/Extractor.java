package com.curseproject.alex.requestparser.manager;

import com.curseproject.alex.requestparser.model.Info;

import java.util.List;

public interface Extractor {
    List<Info> extract(Object obj);
    boolean supports(Object obj);
}
