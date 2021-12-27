package com.curseproject.alex.requestparser.controller;

import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.service.InfoProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/request_parser/api/v1")
public class MainController {

    private final InfoProcessorService service;

    @PostMapping("/from_json")
    public String info(@RequestBody List<Info> request) {
        return service.processRequest(request);
    }

    @PostMapping("/from_file")
    public String getFromFile(@RequestParam("file") MultipartFile file) {
        return service.processRequest(file);
    }

}
