package com.example.personas.infra.output.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("matricula")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EnrollmentEntity {

    @Id
    private Long id;

    @Column("id_persons")
    private Long personId;

    @Column("id_bootcamp")
    private Long bootcampId;
    private String status;
    private LocalDate launchdate;
    private Integer duration;
    @Column("created_at")
    private LocalDateTime createdAt;

}
