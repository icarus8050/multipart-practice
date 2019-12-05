package com.example.multipart.service;

import com.example.multipart.dao.ImageMapper;
import com.example.multipart.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;
    private final String IMAGE_BASE_PATH = "src/main/webapp/WEB-INF/uploadFiles/";

    @Transactional
    public void imageSave(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {
            String filePath = IMAGE_BASE_PATH + file.getOriginalFilename();
            File convertFile = new File(filePath);

            convertFile.createNewFile();
            try (FileOutputStream fout = new FileOutputStream(convertFile)) {
                fout.write(file.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }

            ImageDto dto = new ImageDto();
            dto.setPath(filePath);
            imageMapper.save(dto);
        }

    }
}
