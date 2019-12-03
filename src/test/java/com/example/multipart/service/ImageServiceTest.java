package com.example.multipart.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class ImageServiceTest {

    @Autowired
    ImageService imageService;

    @Test
    @DisplayName("이미지 경로 추가 테스트")
    void simpleImagePathSaveTest() {
        //given
        String imagePath = "/abcd/efg/test.jpg";

        //when
        Long idx = imageService.imageSave(imagePath);

        //then
        assertNotNull(idx);
        log.info(idx.toString());
    }
}