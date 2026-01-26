package com.example.personas.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record BootcampRef(
        UUID bootcampId,
        String name,
        LocalDate startDate,
        LocalDate endDate

) {
}
