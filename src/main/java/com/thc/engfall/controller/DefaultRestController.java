package com.thc.engfall.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @GetMapping("/index")
    public Map<String, Object> index(@RequestParam int p1, @RequestParam int p2){
        System.out.println("p1 : " + p1 + " p2 : " + p2);
        int sum = p1 + p2;
        System.out.println("sum : " + sum);

        Map<String, Object> map = new HashMap<>();
        map.put("sum", sum);
        return map;
    }

    @GetMapping("/index2")
    public Map<String, Object> index2(@RequestParam Map<String, Object> params){
        int p1 = Integer.parseInt(params.get("p1") + "") ;
        int p2 = Integer.parseInt(params.get("p2") + "") ;
        System.out.println("p1 : " + p1 + " p2 : " + p2);
        int sum = p1 + p2;
        System.out.println("sum : " + sum);

        Map<String, Object> map = new HashMap<>();
        map.put("sum", sum);
        return map;
    }

}
