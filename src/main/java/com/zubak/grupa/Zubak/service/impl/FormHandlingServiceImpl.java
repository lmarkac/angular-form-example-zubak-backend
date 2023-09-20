package com.zubak.grupa.Zubak.service.impl;

import com.zubak.grupa.Zubak.constants.Constants;
import com.zubak.grupa.Zubak.dto.FormUploadDTO;
import com.zubak.grupa.Zubak.dto.SuccessfullyUploadedResponse;
import com.zubak.grupa.Zubak.exception.FormUploadException;
import com.zubak.grupa.Zubak.service.FormHandlingService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.io.IOException;

@Service
public class FormHandlingServiceImpl implements FormHandlingService {

    private final JdbcTemplate jdbcTemplate;

    public FormHandlingServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SuccessfullyUploadedResponse uploadFormData(FormUploadDTO formUploadDTO) {
        try {
            byte[] fileBytes = formUploadDTO.getProfileImage().getBytes();

            String sql = "INSERT INTO users (name, email, profile_image) VALUES (?, ?, ?)";

            jdbcTemplate.update(sql,
                    formUploadDTO.getName(),
                    formUploadDTO.getEmail(),
                    fileBytes
            );

            return new SuccessfullyUploadedResponse(Constants.FORM_UPLOADED_SUCCESSFULLY);
        } catch (IOException e) {
            throw new FormUploadException(Constants.FORM_UPLOAD_EXCEPTION_MESSAGE);
        }
    }

}
