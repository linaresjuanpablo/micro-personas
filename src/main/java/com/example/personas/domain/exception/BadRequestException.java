package com.example.personas.domain.exception;

import com.example.personas.domain.exception.error.CommonErrorCode;
import com.example.personas.domain.exception.error.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class BadRequestException extends BusinessException{

    private static final IErrorCode DEFAULT_ERROR_CODE = CommonErrorCode.INVALID_INPUT;


}
