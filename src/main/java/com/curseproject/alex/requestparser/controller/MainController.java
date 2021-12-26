package com.curseproject.alex.requestparser.controller;

import com.curseproject.alex.requestparser.service.InfoProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/request_parser/api/v1")
public class MainController {

    private final InfoProcessorService service;

    @GetMapping("/info")
    public String info() {
        return service.processRequest(null);
    }

    @PostMapping("/from_file")
    public String getFromFile(@RequestParam("test") MultipartFile file) {

        return service.processRequest(file);
    }

}
