package com.thc.engfall.service.impl;

import com.thc.engfall.entity.Board;
import com.thc.engfall.repository.BoardRepositiry;
import com.thc.engfall.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BoradServiceImpl implements BoardService {

    BoardRepositiry boardRepositiry;
    public BoradServiceImpl(BoardRepositiry boardRepositiry){
        this.boardRepositiry = boardRepositiry;
    }

    public Map<String, Object> create(Map<String, Object> params){

        Board board = new Board();
        //board.setId(Long.parseLong(params.get("id") + ""));
        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        boardRepositiry.save(board);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        result.put("id", board.getId());

        return result;
    }
    public Map<String, Object> update(Map<String, Object> params){

        Long id = Long.parseLong(params.get("id").toString());
        String title = (String) params.get("title");
        String content = (String) params.get("content");

        Board board = boardRepositiry.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(title != null){
            board.setTitle(title);
        }
        if(content != null){
            board.setContent(content);
        }
        boardRepositiry.save(board);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        result.put("id", board.getId());

        return result;
    }
    public Map<String, Object> detail(Long id){
        Board board = boardRepositiry.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", board.getId());
        data.put("title", board.getTitle());
        data.put("content", board.getContent());
        result.put("detail", data);

        return result;
    }
}
