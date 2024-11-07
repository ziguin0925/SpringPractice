package com.example.demo.Entity.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ImageDto {
    private String imageName;
    private String extension;
    private String size;

}
