package com.thc.engfall.controller;

import com.thc.engfall.dto.PostDto;
import com.thc.engfall.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/post")
@RestController
public class PostRestController {

    PostService postService;
    public PostRestController(PostService postService){
        this.postService = postService;
    }


    /**/

    @PostMapping("")
    public ResponseEntity<PostDto.CreateResDto> create(@RequestBody PostDto.CreateReqDto params){
        //return ResponseEntity.ok(postService.create(params));
        //System.out.println(params.getImgs().size());
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(params));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostDto.UpdateReqDto params){
        postService.update(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostDto.UpdateReqDto params){
        postService.delete(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/detail")
    public ResponseEntity<PostDto.DetailResDto> detail(PostDto.DetailReqDto params){
        return ResponseEntity.ok(postService.detail(params));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PostDto.DetailResDto>> list(PostDto.ListReqDto params){
        return ResponseEntity.ok(postService.list(params));
    }

    @GetMapping("/pagedList")
    public ResponseEntity<PostDto.PagedListResDto> pagedList(PostDto.PagedListReqDto params){
        return ResponseEntity.ok(postService.pagedList(params));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostDto.DetailResDto>> scrollList(PostDto.ScrollListReqDto params){
        return ResponseEntity.ok(postService.scrollList(params));
    }

}
