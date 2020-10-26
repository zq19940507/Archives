package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Cm2Controller {
    @GetMapping("/cm2")
    public String cm2(){
        return "cm2";
    }

}
