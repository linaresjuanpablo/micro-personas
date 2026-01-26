package com.example.personas.domain.ports.in;

import com.example.personas.infra.input.dto.EnrollmentRequest;
import com.example.personas.infra.input.dto.EnrollmentResponse;
import reactor.core.publisher.Mono;

public interface EnrollmentCommandPort {

    Mono<EnrollmentResponse> enroll(EnrollmentRequest request);
}
