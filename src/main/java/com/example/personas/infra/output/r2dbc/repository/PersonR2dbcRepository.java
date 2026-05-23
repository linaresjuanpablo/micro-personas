package com.example.personas.infra.output.r2dbc.repository;

import com.example.personas.infra.output.r2dbc.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonR2dbcRepository extends ReactiveCrudRepository<PersonEntity, Long> {

    Mono<PersonEntity> findByEmail(String email);

    Mono<PersonEntity> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);


}
