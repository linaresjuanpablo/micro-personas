package com.example.personas.infra.input.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PersonResponse(
        Long id,
        String documentType,
        String documentNumber,
        String names,
        String email,
        String phone,
        LocalDateTime createdAt

) {
}
