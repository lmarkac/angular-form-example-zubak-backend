package com.zubak.grupa.Zubak.controller;

import com.zubak.grupa.Zubak.constants.Constants;
import com.zubak.grupa.Zubak.dto.FormUploadDTO;
import com.zubak.grupa.Zubak.dto.SuccessfullyUploadedResponse;
import com.zubak.grupa.Zubak.service.FormHandlingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/form")
public class FormHandlingController {

    private final FormHandlingService formHandlingService;

    public FormHandlingController(FormHandlingService formHandlingService) {
        this.formHandlingService = formHandlingService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<SuccessfullyUploadedResponse> handleFormUpload(@ModelAttribute FormUploadDTO formUploadDTO) {
        return new ResponseEntity<>(this.formHandlingService.uploadFormData(formUploadDTO), HttpStatus.OK);
    }

}
