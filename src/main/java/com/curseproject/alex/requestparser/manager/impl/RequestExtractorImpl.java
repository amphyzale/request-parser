package com.curseproject.alex.requestparser.manager.impl;

import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.manager.Extractor;
import org.springframework.stereotype.Component;

@Component
public class RequestExtractorImpl implements Extractor {
    @Override
    public Info extract(Object obj) {
        return (Info) obj;
    }

    @Override
    public boolean supports(Object obj) {
        return obj instanceof Info;
    }
}
