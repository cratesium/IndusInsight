package com.indusInsight.net.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public  String homeController(){
        return "Hii this is Home Controller";
    }

    @GetMapping("/author")
    public  String homeController2(){
        return "hii this code is written by shikhar ";
    }

}
