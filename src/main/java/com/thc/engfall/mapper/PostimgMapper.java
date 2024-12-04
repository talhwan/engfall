package com.thc.engfall.mapper;

import com.thc.engfall.dto.PostimgDto;

import java.util.List;

public interface PostimgMapper {
	PostimgDto.DetailResDto detail(Long id);
	List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto params);
}