package com.thc.engfall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("")
@Controller
public class DefaultController {

    @GetMapping("/index")
    public String index(@RequestParam int p1, @RequestParam int p2, Model model){
        System.out.println("p1 : " + p1 + " p2 : " + p2);
        int sum = p1 + p2;
        System.out.println("sum : " + sum);

        model.addAttribute("sum", sum);

        return "index";
        //=> going to find index.html!! (automatically added .html!!)
        // where? under resources/tamplates/
    }
    @GetMapping("/index2")
    public String index2(@RequestParam Map<String, Object> params){
        return "index2";
    }

}
