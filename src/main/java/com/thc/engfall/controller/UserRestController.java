package com.thc.engfall.controller;

import com.thc.engfall.dto.UserDto;
import com.thc.engfall.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping("/signup")
    public ResponseEntity<UserDto.CreateResDto> signup(@RequestBody UserDto.CreateReqDto params){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signup(params));
    }

    /**/

    @PostMapping("")
    public ResponseEntity<UserDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto params){
        //return ResponseEntity.ok(userService.create(params));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(params));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto params){
        userService.update(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto params){
        userService.delete(params);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto params){
        return ResponseEntity.ok(userService.list(params));
    }
    @GetMapping("/detail")
    public ResponseEntity<UserDto.DetailResDto> detail(UserDto.DetailReqDto params){
        return ResponseEntity.ok(userService.detail(params));
    }

}
