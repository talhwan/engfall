package com.thc.engfall.service;

import com.thc.engfall.dto.PostimgDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostimgService {
    /**/
    PostimgDto.CreateResDto create(PostimgDto.CreateReqDto params);
    void update(PostimgDto.UpdateReqDto params);
    void delete(PostimgDto.UpdateReqDto params);
    PostimgDto.DetailResDto detail(PostimgDto.DetailReqDto params);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto params);
}
