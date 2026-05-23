package com.example.personas.infra.input.dto;

import java.time.LocalDateTime;

public record PersonRequest(
        String documentType,
        String documentNumber,
        String names,
        String email,
        String phone,
        LocalDateTime createdAt

) {
}
