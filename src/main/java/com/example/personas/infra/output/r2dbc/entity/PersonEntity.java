package com.example.personas.infra.output.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("persons")

public class PersonEntity {

    @Id
    private Long id;
    private String documentType;
    private String documentNumber;
    private String names;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

}
