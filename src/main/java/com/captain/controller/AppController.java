package com.captain.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/captain/version")
@Api(value = "captain/version",
        description = "captain",
        tags = "captain")
public class AppController {

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(position = 0,
            value = "version",
            httpMethod = "GET",
            response = String.class,
            notes = "version")
    private ResponseEntity<String> version() {
        return ResponseEntity.ok(appName + " 1.0");
    }
}