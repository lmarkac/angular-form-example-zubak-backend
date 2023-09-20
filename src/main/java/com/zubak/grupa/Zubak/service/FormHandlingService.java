package com.zubak.grupa.Zubak.service;

import com.zubak.grupa.Zubak.dto.FormUploadDTO;
import com.zubak.grupa.Zubak.dto.SuccessfullyUploadedResponse;
import com.zubak.grupa.Zubak.exception.FormUploadException;

public interface FormHandlingService {

    SuccessfullyUploadedResponse uploadFormData(FormUploadDTO formUploadDTO);

}
