package com.poc.docker_cicd.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rough")
public class RoughController {

    @GetMapping("/name")
    public String printName() {
        return "Abhinav Sharma Ji";
    }

}
