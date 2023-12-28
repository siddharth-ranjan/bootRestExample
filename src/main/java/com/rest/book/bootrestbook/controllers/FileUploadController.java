package com.rest.book.bootrestbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class FileUploadController {

    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());

        if(file.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select image and then upload");

        if(!Objects.equals(file.getContentType(), "image/jpeg"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select image of supported type.");



        return ResponseEntity.ok("Working fine");

    }
}
