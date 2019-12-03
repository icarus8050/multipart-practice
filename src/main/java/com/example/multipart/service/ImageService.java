package com.example.multipart.service;

import com.example.multipart.dao.ImageMapper;
import com.example.multipart.dto.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageMapper imageMapper;

    @Transactional
    public Long imageSave(String path) {
        ImageDto dto = new ImageDto();
        dto.setPath(path);
        imageMapper.save(dto);

        return dto.getIdx();
    }
}
