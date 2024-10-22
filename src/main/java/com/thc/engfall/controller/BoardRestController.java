package com.thc.engfall.controller;

import com.thc.engfall.entity.Board;
import com.thc.engfall.repository.BoardRepositiry;
import com.thc.engfall.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    BoardService boardService;
    public BoardRestController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return boardService.create(params);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return boardService.update(params);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        /*Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", HttpStatus.OK.value());
        resultMap.put("list", list);
        return resultMap;*/
        return null;
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Long id){
        return boardService.detail(id);
    }

}
