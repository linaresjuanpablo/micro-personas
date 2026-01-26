package com.example.personas.infra.output.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("matricula")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EnrollmentEntity {

    @Id
    private UUID id;
    private UUID personId;
    private UUID bootcampId;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;

}
