package com.girl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path = "/girl", method = RequestMethod.GET)
    public String say() {
        return "HelloWorld";
    }
}
