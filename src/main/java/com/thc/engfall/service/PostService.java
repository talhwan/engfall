package com.thc.engfall.service;

import com.thc.engfall.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    /**/
    PostDto.CreateResDto create(PostDto.CreateReqDto params);
    void update(PostDto.UpdateReqDto params);
    void delete(PostDto.UpdateReqDto params);
    PostDto.DetailResDto detail(PostDto.DetailReqDto params);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto params);
    PostDto.PagedListResDto pagedList(PostDto.PagedListReqDto params);
}
