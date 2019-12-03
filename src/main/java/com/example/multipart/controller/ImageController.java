package com.example.multipart.controller;

import com.example.multipart.service.ImageService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    @ResponseBody
    public String savePath(@RequestBody PathDto dto) {
        imageService.imageSave(dto.getPath());

        return "success";
    }

    @NoArgsConstructor
    @Data
    private static class PathDto {
        String path;
    }
}
