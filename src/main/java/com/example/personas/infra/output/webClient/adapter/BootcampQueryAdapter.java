package com.example.personas.infra.output.webClient.adapter;

import com.example.personas.domain.model.BootcampRef;
import com.example.personas.domain.ports.out.BootcampQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor

public class BootcampQueryAdapter implements BootcampQueryPort {

    private final WebClient webClient;

    @Override
    public Mono<BootcampRef> getBootcampById(Long bootcampId) {
        return webClient.get()
                .uri("/api/bootcamp/{id}", bootcampId)
                .retrieve()
                .bodyToMono(BootcampRef.class)
                ;
    }
}
