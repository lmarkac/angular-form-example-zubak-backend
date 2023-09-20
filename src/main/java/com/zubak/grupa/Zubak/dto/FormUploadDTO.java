package com.zubak.grupa.Zubak.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FormUploadDTO {

    private String name;
    private String email;
    private MultipartFile profileImage;

}
