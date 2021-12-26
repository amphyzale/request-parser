package com.curseproject.alex.requestparser.manager;

import com.curseproject.alex.requestparser.model.Info;

public interface Extractor {
    Info extract(Object obj);
    boolean supports(Object obj);
}
