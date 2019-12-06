package com.example.multipart.controller;

import com.example.multipart.service.ImageService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String saveImage(MultipartHttpServletRequest mtfRequest) throws IOException {
        List<MultipartFile> files = mtfRequest.getFiles("files");
        imageService.imageSave(files);

        return "redirect:/";
    }

    @NoArgsConstructor
    @Data
    private static class PathDto {
        String path;
    }
}
