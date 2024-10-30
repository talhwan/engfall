package com.thc.engfall.controller;

import com.thc.engfall.dto.UserDto;
import com.thc.engfall.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/user")
@RestController
public class UserRestController {

    UserService userService;
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto.CreateResDto> login(@RequestBody UserDto.LoginReqDto params){
        return ResponseEntity.ok(userService.login(params));
    }
    @GetMapping("/signup")
    public Map<String, Object> signup(@RequestParam Map<String, Object> params){
        return userService.signup(params);
    }

    /**/

    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params){
        return userService.create(params);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params){
        return userService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Long id){
        return userService.delete(id);
    }

    @GetMapping("/list")
    public Map<String, Object> list(){
        return userService.list();
    }
    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam Long id){
        return userService.detail(id);
    }

}
