package com.curseproject.alex.requestparser.controller;

import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.model.Response;
import com.curseproject.alex.requestparser.service.InfoProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/request_parser/api/v1")
public class MainController {

    private final InfoProcessorService service;

    @PostMapping("/from_json")
    public Response info(@RequestBody @NotEmpty @Size(min=1) List<@Valid Info> request) {
        return service.processRequest(request);
    }

    @PostMapping("/from_file")
    public Response getFromFile(@RequestParam("file") MultipartFile file) {
        return service.processRequest(file);
    }

}
