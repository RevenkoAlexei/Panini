package com.pani.gameplatform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class NavigationController {


    @RequestMapping("/")
    public String getAllAvailableActions(){
        return "index.html";
    }
}
