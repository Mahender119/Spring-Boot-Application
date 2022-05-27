package com.codebuffer.gateway.api;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    private static final String getUserWitDepartments ="getUserWithDepartment";
    @CircuitBreaker(name ="getUserWitDepartments",fallbackMethod = "userServiceFallBackMethod")
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "user Service is taking longer than expected." +
                "Please try again later";
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod (){
        return "department Service is taking longer than expected." +
                "Please try again later";
    }
}
