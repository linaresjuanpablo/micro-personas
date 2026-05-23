package com.example.personas.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record BootcampRef(
        Long bootcampId,
        String name,
        LocalDate launchdate,
        Integer duration

) {
}
