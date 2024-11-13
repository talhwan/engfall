package com.thc.engfall.service.impl;

import com.thc.engfall.dto.UserDto;
import com.thc.engfall.entity.User;
import com.thc.engfall.mapper.UserMapper;
import com.thc.engfall.repository.UserRepositiry;
import com.thc.engfall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    UserRepositiry userRepositiry;
    UserMapper userMapper;
    public UserServiceImpl(
            UserRepositiry userRepositiry
            , UserMapper userMapper
    ){
        this.userRepositiry = userRepositiry;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto.CreateResDto login(UserDto.LoginReqDto params){
        if(params.getUsername() == null || params.getPassword() == null){
            throw new RuntimeException("neccessary parameters");
        }
        User user = userRepositiry.findByUsernameAndPassword(params.getUsername(), params.getPassword());
        if(user == null){
            throw new RuntimeException("id or password incorrect");
        }
        return UserDto.CreateResDto.builder().id(user.getId()).build();
    }
    @Override
    public UserDto.CreateResDto signup(UserDto.CreateReqDto params){
        //add some functions?!
        //here!!
        return create(params);
    }

    @Override
    public UserDto.CreateResDto create(UserDto.CreateReqDto params){
        User user = userRepositiry.findByUsername(params.getUsername());
        if(user != null){
            throw new RuntimeException("username already exist");
        }
        return userRepositiry.save(params.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto params){
        User user = userRepositiry.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(params.getPassword() != null){
            user.setPassword(params.getPassword());
        }
        if(params.getName() != null){
            user.setName(params.getName());
        }
        if(params.getPhone() != null){
            user.setPhone(params.getPhone());
        }
        if(params.getGender() != null){
            user.setGender(params.getGender());
        }
        userRepositiry.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto params){
        User user = userRepositiry.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        user.setDeleted(true);
        userRepositiry.save(user);
    }

    public UserDto.DetailResDto get(Long id){
        UserDto.DetailResDto returnvalue = userMapper.detail(id);
        return returnvalue;
    }
    @Override
    public UserDto.DetailResDto detail(UserDto.DetailReqDto params){
        return get(params.getId());
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto params){
        List<UserDto.DetailResDto> list = userMapper.list(params);
        List<UserDto.DetailResDto> newList = new ArrayList<>();
        for(UserDto.DetailResDto each : list){
            newList.add( get(each.getId()) );
        }
        return newList;
    }
}
