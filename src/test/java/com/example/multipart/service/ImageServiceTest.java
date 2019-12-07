package com.example.multipart.service;

import com.example.multipart.dto.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ImageServiceTest {

    @Autowired
    ImageService imageService;

    @Test
    @DisplayName("이미지 경로 모두 검색")
    void simpleImagePathFindAll() {
        //given

        //when
        List<ImageDto> imagePaths = imageService.findAll();

        //then
        assertNotNull(imagePaths);
        for (ImageDto imagePath : imagePaths) {
            log.info("Found imagePath => {}", imagePath.getImage_path());
        }
    }

    /*@Test
    @DisplayName("이미지 경로 추가 테스트")
    @Deprecated
    void simpleImagePathSaveTest() {
        //given
        String imagePath = "/abcd/efg/test.jpg";

        //when
        Long idx = imageService.imageSave(imagePath);

        //then
        assertNotNull(idx);
        log.info(idx.toString());
    }*/
}