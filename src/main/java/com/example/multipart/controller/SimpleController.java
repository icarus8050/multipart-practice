package com.example.multipart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("serverName", "Multipart Server!!!");

        return "hello";
    }
}
