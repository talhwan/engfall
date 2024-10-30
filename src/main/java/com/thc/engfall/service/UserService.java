package com.thc.engfall.service;

import com.thc.engfall.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    UserDto.CreateResDto login(UserDto.LoginReqDto params);
    Map<String, Object> signup(Map<String, Object> params);
    /**/
    Map<String, Object> create(Map<String, Object> params);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Long id);
    Map<String, Object> detail(Long id);
    Map<String, Object> list();
}
