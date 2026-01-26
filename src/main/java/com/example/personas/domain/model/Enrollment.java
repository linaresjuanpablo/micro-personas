package com.example.personas.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Enrollment {
    private UUID id;
    private UUID personId;
    private UUID bootcampId;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;

    public static Enrollment create(UUID personId, UUID bootcampId,
                                    LocalDate startDate, LocalDate endDate) {
        return Enrollment.builder()
                /*UUID.randomUUID(),
                personId,
                bootcampId,
                "ACTIVE",
                startDate,
                endDate,
                LocalDateTime.now()
        );*/
                .id(UUID.randomUUID())
                .personId(personId)
                .bootcampId(bootcampId)
                .status("ACTIVE")
                .startDate(startDate)
                .endDate(endDate)
                .createdAt(LocalDateTime.now())
                .build();

    }

}



