package com.example.personas.domain.exception.error;

public interface IErrorCode {

    String getCode();
    String getMessage();
    int getStatusCode();

    ErrorPersonas getPersonas();

}
