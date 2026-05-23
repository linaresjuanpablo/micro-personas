package com.example.personas.infra.input.dto;

import java.util.UUID;

public record EnrollmentRequest(
        Long personId,
        Long bootcampId
) {
}
