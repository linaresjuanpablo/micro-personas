package com.example.personas.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private UUID id;
    private String documentType;
    private String documentNumber;
    private String names;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

}
