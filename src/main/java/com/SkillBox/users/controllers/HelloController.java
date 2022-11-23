package com.SkillBox.users.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Operation(summary = "Тестовый контроллер")
    @GetMapping("/")
    public String index() {
        return "Hello world from users service!";
    }
}