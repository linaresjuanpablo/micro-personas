package com.example.personas.infra.input.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record EnrollmentResponse(
        Long enrollmentId,
        Long personId,
        Long bootcampId,
        String status,
        LocalDate launchdate,
        Integer duration,
        LocalDateTime createdAt

) {
}
