package com.thc.engfall.service.impl;

import com.thc.engfall.dto.UserDto;
import com.thc.engfall.entity.User;
import com.thc.engfall.mapper.UserMapper;
import com.thc.engfall.repository.UserRepository;
import com.thc.engfall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    public UserServiceImpl(
            UserRepository userRepository
            , UserMapper userMapper
    ){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto.CreateResDto login(UserDto.LoginReqDto params){
        if(params.getUsername() == null || params.getPassword() == null){
            throw new RuntimeException("neccessary parameters");
        }
        User user = userRepository.findByUsernameAndPassword(params.getUsername(), params.getPassword());
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
        User user = userRepository.findByUsername(params.getUsername());
        if(user != null){
            throw new RuntimeException("username already exist");
        }
        return userRepository.save(params.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto params){
        User user = userRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
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
        userRepository.save(user);
    }

    @Override
    public void delete(UserDto.UpdateReqDto params){
        User user = userRepository.findById(params.getId()).orElseThrow(() -> new RuntimeException("no data"));
        user.setDeleted(true);
        userRepository.save(user);
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
