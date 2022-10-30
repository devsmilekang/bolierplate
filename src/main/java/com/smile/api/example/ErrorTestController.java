package com.smile.api.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorTestController {

    @GetMapping("/parameterError")
    public String parameterError(Integer integer) {
        return integer.toString();
    }
}
