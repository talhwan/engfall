package com.thc.engfall.service.impl;

import com.thc.engfall.dto.UserDto;
import com.thc.engfall.entity.User;
import com.thc.engfall.repository.UserRepositiry;
import com.thc.engfall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    UserRepositiry userRepositiry;
    public UserServiceImpl(UserRepositiry userRepositiry){
        this.userRepositiry = userRepositiry;
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
    public Map<String, Object> signup(Map<String, Object> params){
        //add some functions?!
        //here!!
        return create(params);
    }

    @Override
    public Map<String, Object> create(Map<String, Object> params){

        User user = new User();
        user.setUsername(params.get("username").toString());
        user.setPassword(params.get("password").toString());
        user.setName(params.get("name").toString());
        if(params.get("phone") != null){
            user.setPhone(params.get("phone").toString());
        }

        User user2 = userRepositiry.findByUsername(params.get("username").toString());
        if(user2 != null){
            throw new RuntimeException("username already exist");
        }
        userRepositiry.save(user);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        result.put("id", user.getId());

        return result;
    }

    @Override
    public Map<String, Object> update(Map<String, Object> params){

        Long id = Long.parseLong(params.get("id").toString());
        String name = (String) params.get("name");
        String phone = (String) params.get("phone");

        User user = userRepositiry.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        if(name != null){
            user.setName(name);
        }
        if(phone != null){
            user.setPhone(phone);
        }
        userRepositiry.save(user);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        result.put("id", user.getId());

        return result;
    }

    @Override
    public Map<String, Object> delete(Long id){
        User user = userRepositiry.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        userRepositiry.delete(user);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        return result;
    }

    @Override
    public Map<String, Object> detail(Long id){
        User user = userRepositiry.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("name", user.getName());
        data.put("phone", user.getPhone());
        data.put("birth", user.getBirth());
        result.put("detail", data);

        return result;
    }

    @Override
    public Map<String, Object> list(){
        List<User> listUser = userRepositiry.findAll();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", 200);
        result.put("list", listUser);

        return result;
    }
}
