package com.thc.engfall.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/board")
@Controller
public class BoardController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }

    @GetMapping("/{page}/{uniqueId}")
    public String page2(@PathVariable String page, @PathVariable String uniqueId){
        return "board/" + page;
    }
    /*
    @GetMapping("/list")
    public String list(){
        return "board/list";
    }
    @GetMapping("/create")
    public String create(){
        return "board/create";
    }*/

}
