package com.example.personas.infra.output.r2dbc.adapter;

import com.example.personas.domain.model.Person;
import com.example.personas.domain.ports.out.PersonRepositoryPort;
import com.example.personas.infra.output.mapper.PersonMapper;
import com.example.personas.infra.output.r2dbc.entity.PersonEntity;
import com.example.personas.infra.output.r2dbc.repository.PersonR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor

public class PersonRepositoryAdapter implements PersonRepositoryPort {

    private final PersonR2dbcRepository repository;
    private final PersonMapper mapper;

    @Override
    public Mono<Person> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public Mono<Person> save(Person person) {
        PersonEntity entity = mapper.toEntity(person);
        return repository.save(entity)
                .map(mapper::toDomain);
    }
    @Override
    public Mono<Person> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toDomain);
    }
    @Override
    public Mono<Person> findByDocument(String documentType, String documentNumber) {
        return repository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber)
                .map(mapper::toDomain);
    }
}
