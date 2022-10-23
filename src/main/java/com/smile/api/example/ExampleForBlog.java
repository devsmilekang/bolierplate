package com.smile.api.example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleForBlog {

    @GetMapping("/error-test")
    public String MavenLocalRepositoryForceError() {
        StringUtils.getDigits("1");
        return "No Problem";
    }
}
