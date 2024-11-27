package com.thc.engfall.controller;

import com.thc.engfall.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Long id){
        return boardService.delete(id);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        return boardService.list();
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Long id){
        return boardService.detail(id);
    }

}
