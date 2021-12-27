package com.curseproject.alex.requestparser.manager.impl;

import com.curseproject.alex.requestparser.manager.InfoProcessor;
import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.model.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InfoProcessorImpl implements InfoProcessor {

    private final RestTemplate template;

    @Override
    public Response processInfo(List<Info> info) {
        log.info(info.toString());
        return template.postForObject("/calculate", info, Response.class);
    }
}
