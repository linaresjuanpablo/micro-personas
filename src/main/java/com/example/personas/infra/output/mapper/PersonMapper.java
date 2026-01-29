package com.example.personas.infra.output.mapper;

import com.example.personas.domain.model.Person;
import com.example.personas.infra.output.r2dbc.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component

public class PersonMapper {

    public Person toDomain(PersonEntity entity) {
        if (entity == null) return null;
        return new Person(
                entity.getId(),
                entity.getDocumentType(),
                entity.getDocumentNumber(),
                entity.getNames(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCreatedAt()
        );
    }

    public PersonEntity toEntity(Person person) {
        if (person == null) return null;
        return PersonEntity.builder()
                .id(person.getId())
                .documentType(person.getDocumentType())
                .documentNumber(person.getDocumentNumber())
                .names(person.getNames())
                .email(person.getEmail())
                .phone(person.getPhone())
                .createdAt(person.getCreatedAt())
                .build();
    }


}
