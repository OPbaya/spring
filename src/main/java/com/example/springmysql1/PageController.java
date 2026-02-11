package com.example.springmysql1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class PageController {

    @GetMapping("/hello")
    public String helloPage(Model model) {
        model.addAttribute("name", "Priyansh");
        return "hello";
    }

}
