package com.example.personas.infra.input.controller;

import com.example.personas.application.useCase.CreatePersonUseCase;
import com.example.personas.domain.model.Person;
import com.example.personas.domain.ports.out.PersonRepositoryPort;
import com.example.personas.infra.input.dto.PersonRequest;
import com.example.personas.infra.input.dto.PersonResponse;
import com.example.personas.infra.output.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor

public class PersonController {

    private final PersonRepositoryPort personRepository;
    private final PersonMapper mapper;
    private final CreatePersonUseCase createPersonUseCase;

    @PostMapping("/create")
    public Mono<PersonResponse> createPerson(@RequestBody PersonRequest request){
        Person person = new Person(
                null,
                request.documentType(),
                request.documentNumber(),
                request.names(),
                request.email(),
                request.phone(),
                request.createdAt()
        );
        return  createPersonUseCase.create(person)
                .map(p-> new PersonResponse(
                        p.getId(),
                        p.getDocumentType(),
                        p.getDocumentNumber(),
                        p.getNames(),
                        p.getEmail(),
                        p.getPhone(),
                        p.getCreatedAt()

                ));
    }
    @GetMapping("/id")
    public Mono<PersonResponse> getPersonById(@PathVariable Long id){
        return personRepository.findById(id)
                .map(p -> new PersonResponse(
                        p.getId(),
                        p.getDocumentType(),
                        p.getDocumentNumber(),
                        p.getNames(),
                        p.getEmail(),
                        p.getPhone(),
                        p.getCreatedAt()
                ));
    }
    @GetMapping("/email/{email}")
    public Mono<PersonResponse> getPersonByEmail(@PathVariable String email) {
        return personRepository.findByEmail(email)
                .map(p -> new PersonResponse(
                        p.getId(),
                        p.getDocumentType(),
                        p.getDocumentNumber(),
                        p.getNames(),
                        p.getEmail(),
                        p.getPhone(),
                        p.getCreatedAt()
                ));
    }
    @GetMapping("/document")
    public Mono<PersonResponse> getPersonByDocument(@RequestParam String type,
                                                    @RequestParam String number) {
        return personRepository.findByDocument(type, number)
                .map(p -> new PersonResponse(
                        p.getId(),
                        p.getDocumentType(),
                        p.getDocumentNumber(),
                        p.getNames(),
                        p.getEmail(),
                        p.getPhone(),
                        p.getCreatedAt()
                ));
    }
}
