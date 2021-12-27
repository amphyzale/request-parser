package com.curseproject.alex.requestparser.manager.impl;

import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.manager.Extractor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
public class RequestExtractorImpl implements Extractor {
    @Override
    public List<Info> extract(Object obj) {
        return new LinkedList<>((Collection<? extends Info>) obj);
    }

    @Override
    public boolean supports(Object obj) {
        return obj instanceof List;
    }
}
