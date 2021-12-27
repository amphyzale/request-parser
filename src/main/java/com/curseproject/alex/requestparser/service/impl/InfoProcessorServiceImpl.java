package com.curseproject.alex.requestparser.service.impl;

import com.curseproject.alex.requestparser.manager.Extractor;
import com.curseproject.alex.requestparser.manager.InfoProcessor;
import com.curseproject.alex.requestparser.model.Response;
import com.curseproject.alex.requestparser.service.InfoProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoProcessorServiceImpl implements InfoProcessorService {

    private final List<Extractor> extractors;
    private final InfoProcessor processor;

    @Override
    public Response processRequest(Object obj) {
        for (Extractor e : extractors) {
            if (e.supports(obj)) {
                return processor.processInfo(e.extract(obj));
            }
        }
        throw new RuntimeException();
    }
}
