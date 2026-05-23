package com.example.personas.application.useCase;

import com.example.personas.domain.model.Person;
import com.example.personas.domain.ports.in.CreatePersonUseCasePort;
import com.example.personas.domain.ports.out.PersonRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class CreatePersonUseCase implements CreatePersonUseCasePort {

    private final PersonRepositoryPort personRepository;

    public Mono<Person> create(Person person) {


        return personRepository.findByDocument(person.getDocumentType(), person.getDocumentNumber())
                .flatMap(existing-> Mono.<Person>error(new IllegalArgumentException("Ya existe una persona con ese documento")))
                .switchIfEmpty(
                        personRepository.findByEmail(person.getEmail())
                                .flatMap(existing -> Mono.<Person>error(new IllegalArgumentException("Ya existe una persona con ese email")))
                                .switchIfEmpty(
                                        personRepository.save(person)
                                )
                );
    }

}
