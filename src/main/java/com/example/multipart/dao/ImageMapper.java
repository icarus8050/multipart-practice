package com.example.multipart.dao;

import com.example.multipart.dto.ImageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageMapper {
    List<ImageDto> findAll();
    Long save(ImageDto imageDto);
}
