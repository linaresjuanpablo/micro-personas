package com.example.personas.infra.output.r2dbc.repository;

import com.example.personas.infra.output.r2dbc.entity.EnrollmentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface EnrollmentR2dbcRepository extends ReactiveCrudRepository<EnrollmentEntity, UUID> {
    Flux<EnrollmentEntity> findByPersonId(Long personId);
    Flux<EnrollmentEntity> findByPersonIdAndStatus(Long personId, String status);
}




