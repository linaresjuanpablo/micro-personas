package com.example.personas.domain.ports.out;

import com.example.personas.domain.model.Enrollment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface EnrollmentRepositoryPort {

    Mono<Enrollment> save(Enrollment enrollment);

    Flux<Enrollment> findActiveByPerson(Long personId);

    Flux<Enrollment> findByPerson(Long personId);



}
