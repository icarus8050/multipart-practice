package com.example.multipart.lib;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ImageUtilsTest {

    @Test
    public void imageResizeTest() throws IOException {
        Resource resource = new ClassPathResource("dog.jpg");

        BufferedImage resizedImage =
                ImageUtils.resize(resource.getInputStream(), 800, 600);

        ImageIO.write(resizedImage, "jpg", new File("src/main/resources/dog_2.jpg"));
    }
}