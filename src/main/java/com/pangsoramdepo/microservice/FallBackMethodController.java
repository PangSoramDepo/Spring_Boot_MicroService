package com.pangsoramdepo.microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service Is Taking Longer Than Expected";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service Is Taking Longer Than Expected";
    }
}
