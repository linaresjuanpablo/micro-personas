package com.example.personas.infra.input.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record EnrollmentResponse(
        UUID enrollmentId,
        UUID personId,
        UUID bootcampId,
        String status,
        LocalDate startDate,
        LocalDate endDate,
        LocalDateTime createdAt

) {
}
