package com.example.personas.infra.input.controller;

import com.example.personas.application.useCase.EnrollPersonUseCase;
import com.example.personas.infra.input.dto.EnrollmentRequest;
import com.example.personas.infra.input.dto.EnrollmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persons/enrollments")
@RequiredArgsConstructor

public class EnrollmentController {

    private final EnrollPersonUseCase enrollPersonUseCase;

    @PostMapping("/create")
    public Mono<EnrollmentResponse> enroll(@RequestBody EnrollmentRequest request){
        return enrollPersonUseCase.enroll(request);
    }
}
