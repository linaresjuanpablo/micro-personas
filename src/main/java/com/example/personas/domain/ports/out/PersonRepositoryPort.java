package com.example.personas.domain.ports.out;

import com.example.personas.domain.model.Person;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonRepositoryPort {

    Mono<Person> findById(UUID id);
    Mono<Person> save(Person person);
    Mono<Person> findByEmail(String email);
    Mono<Person> findByDocument(String documentType, String documentNumber);
}
