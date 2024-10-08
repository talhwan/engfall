package com.thc.engfall.controller;

import com.thc.engfall.entity.Board;
import com.thc.engfall.repository.BoardRepositiry;
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

    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

    BoardRepositiry boardRepositiry;
    public BoardRestController(BoardRepositiry boardRepositiry){
        this.boardRepositiry = boardRepositiry;
    }

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){

        Board board = new Board();
        board.setId(Long.parseLong(params.get("id") + ""));
        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        boardRepositiry.save(board);


        String title = (String) params.get("title");
        String content = (String) params.get("content");

        int order = list.size() + 1;

        Map<String, Object> eachBoard = new HashMap<>();
        eachBoard.put("title", title);
        eachBoard.put("content", content);
        eachBoard.put("order", order);

        list.add(eachBoard);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", HttpStatus.OK.value());
        resultMap.put("order", order);
        return resultMap;
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        String title = (String) params.get("title");
        String content = (String) params.get("content");

        int order = Integer.parseInt((String) params.get("order")) - 1;
        Map<String, Object> board = list.get(order);
        if(title != null){
            board.put("title", title);
        }
        if(content != null){
            board.put("content", content);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", HttpStatus.OK.value());
        resultMap.put("order", order + 1);
        return resultMap;
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", HttpStatus.OK.value());
        resultMap.put("list", list);
        return resultMap;
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Map<String, Object> params){
        int order = Integer.parseInt((String) params.get("order"));
        Map<String, Object> eachBoard = list.get(order - 1);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", HttpStatus.OK.value());
        resultMap.put("detail", eachBoard);
        return resultMap;
    }

}
