package com.example.personas.domain.ports.in;

import com.example.personas.domain.model.Person;
import reactor.core.publisher.Mono;

public interface CreatePersonUseCasePort {

    Mono<Person> create(Person person);

}
