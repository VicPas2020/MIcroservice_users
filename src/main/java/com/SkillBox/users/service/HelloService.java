package com.SkillBox.users.service;

import com.SkillBox.users.controllers.HelloController;

public class HelloService {

    public HelloController helloController;

    public String start() {
        return helloController.index();
    }
}
