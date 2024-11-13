package com.thc.engfall.mapper;

import com.thc.engfall.dto.UserDto;

import java.util.List;

public interface UserMapper {
	UserDto.DetailResDto detail(Long id);
	List<UserDto.DetailResDto> list(UserDto.ListReqDto params);
}