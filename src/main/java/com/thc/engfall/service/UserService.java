package com.thc.engfall.service;

import com.thc.engfall.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    UserDto.CreateResDto login(UserDto.LoginReqDto params);
    UserDto.CreateResDto signup(UserDto.CreateReqDto params);
    /**/
    UserDto.CreateResDto create(UserDto.CreateReqDto params);
    void update(UserDto.UpdateReqDto params);
    void delete(UserDto.UpdateReqDto params);
    UserDto.DetailResDto detail(UserDto.DetailReqDto params);
    List<UserDto.DetailResDto> list();
}
