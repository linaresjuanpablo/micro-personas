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
    private Long id;
    private Long personId;
    private Long bootcampId;
    private String status;
    private LocalDate launchdate;
    private Integer duration;
    private LocalDateTime createdAt;

    public static Enrollment create(Long personId, Long bootcampId,
                                    LocalDate launchdate, Integer duration) {
        return Enrollment.builder()
                /*UUID.randomUUID(),
                personId,
                bootcampId,
                "ACTIVE",
                startDate,
                endDate,
                LocalDateTime.now()
        );*/
                .personId(personId)
                .bootcampId(bootcampId)
                .status("ACTIVE")
                .launchdate(launchdate)
                .duration(duration)
                .createdAt(LocalDateTime.now())
                .build();

    }

}



