package com.example.multipart.service;

import com.example.multipart.dao.ImageMapper;
import com.example.multipart.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ImageMapper imageMapper;
    private final String IMAGE_BASE_PATH = "src/main/webapp/WEB-INF/uploadFiles/";

    @Transactional
    public void imageSave(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            Long fileSize = file.getSize();

            String filePath = IMAGE_BASE_PATH + System.currentTimeMillis() + "-" + fileName;

            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {

                outputStream.write(file.getBytes());

                ImageDto dto = new ImageDto();
                dto.setPath(filePath);
                imageMapper.save(dto);

            } catch (Exception e) {
                e.printStackTrace();
            }

            log.info("File name ==> {}", fileName);
            log.info("File size ==> {}", fileSize);
        }

    }
}
