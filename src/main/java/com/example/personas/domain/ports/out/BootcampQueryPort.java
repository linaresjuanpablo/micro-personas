package com.example.personas.domain.ports.out;

import com.example.personas.domain.model.BootcampRef;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BootcampQueryPort {

    Mono<BootcampRef> getBootcampById(UUID bootcampId);

}
