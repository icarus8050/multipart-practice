package com.example.multipart.dao;

import com.example.multipart.dto.ImageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {
    Long save(ImageDto imageDto);
}
