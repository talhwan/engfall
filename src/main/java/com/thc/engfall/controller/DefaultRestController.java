package com.thc.engfall.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        System.out.println("filename : "+ filename);

        String filePath = "C:/workspace/uploadfiles/engfall/";
        File newfile = new File(filePath);
        if(!newfile.exists()) {
            newfile.mkdirs();
        }

        Date date = new Date();
        String temp_date = date.getTime() + "";
        String returnValue = temp_date + "_" + filename;

        FileCopyUtils.copy(file.getBytes(), new File(filePath + returnValue));
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
