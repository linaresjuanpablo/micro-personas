package com.example.personas.infra.output.r2dbc.adapter;

import com.example.personas.domain.model.Enrollment;
import com.example.personas.domain.ports.out.EnrollmentRepositoryPort;
import com.example.personas.infra.output.mapper.EnrollmentMapper;
import com.example.personas.infra.output.r2dbc.repository.EnrollmentR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor

public class EnrollmentRepositoryAdapter implements EnrollmentRepositoryPort {

    private final EnrollmentR2dbcRepository repository;
    private final EnrollmentMapper mapper;

    @Override
    public Mono<Enrollment> save(Enrollment enrollment) {
        return repository.save(mapper.toEntity(enrollment))
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Enrollment> findActiveByPerson(Long personId) {
        return repository.findByPersonIdAndStatus(personId, "ACTIVE")
                .map(mapper::toDomain);
    }

    @Override
    public Flux<Enrollment> findByPerson(Long personId) {
        return repository.findByPersonId(personId)
                .map(mapper::toDomain);
    }
}
