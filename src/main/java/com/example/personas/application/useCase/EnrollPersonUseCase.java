package com.example.personas.application.useCase;


import com.example.personas.domain.exception.ValidationException;

import com.example.personas.domain.model.BootcampRef;
import com.example.personas.domain.model.Enrollment;
import com.example.personas.domain.ports.in.EnrollmentCommandPort;
import com.example.personas.domain.ports.out.BootcampQueryPort;
import com.example.personas.domain.ports.out.EnrollmentRepositoryPort;
import com.example.personas.domain.ports.out.PersonRepositoryPort;
import com.example.personas.infra.input.dto.EnrollmentRequest;
import com.example.personas.infra.input.dto.EnrollmentResponse;
import com.example.personas.infra.output.mapper.EnrollmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EnrollPersonUseCase implements EnrollmentCommandPort {

    private final PersonRepositoryPort personRepository;
    private final EnrollmentRepositoryPort enrollmentRepository;
    private final BootcampQueryPort bootcampQuery;
    private final EnrollmentMapper mapper;

    private static final int MAX_ACTIVE_ENROLLMENTS = 5;
    private static final String ACTIV_MAX_INSCRI = "Máximo de inscripciones activas alcanzado";

    @Override
    public Mono<EnrollmentResponse> enroll(EnrollmentRequest request) {
        return personRepository.findById(request.personId())
                .switchIfEmpty(Mono.error(new ValidationException("Persona no encontrada")))
                .flatMap(person -> bootcampQuery.getBootcampById(request.bootcampId()))
                .flatMap(bootcamp -> validateBootcampDates(bootcamp)
                        .then(enrollmentRepository.findActiveByPerson(request.personId()).collectList())
                        .flatMap(activeEnrollments -> validateEnrollmentRules(activeEnrollments, bootcamp)
                                .then(saveEnrollment(request, bootcamp))
                        )
                );
    }

    private Mono<Void> validateBootcampDates(BootcampRef bootcamp) {
        LocalDate launchdate = bootcamp.launchdate();
        Integer duration = bootcamp.duration();
        if (launchdate == null || duration == null ) {
            return Mono.error(new ValidationException("Fechas del bootcamp inválidas"));
        }
        return Mono.empty();
    }
    private Mono<Void> validateEnrollmentRules(List<Enrollment> activeEnrollments, BootcampRef bootcamp) {
        if (activeEnrollments.size() >= MAX_ACTIVE_ENROLLMENTS) {
            return Mono.error(new ValidationException(ACTIV_MAX_INSCRI ));
        }
        LocalDate launchDate = bootcamp.launchdate();
        Integer duration = bootcamp.duration();

        if (launchDate == null || duration == null) {
            return Mono.error(new ValidationException("Fechas del bootcamp inválidas"));
        }

        boolean sameDate = activeEnrollments.stream()
                .anyMatch(e -> launchDate.equals(e.getLaunchdate()));

        if (sameDate){
            return Mono.error(new ValidationException("Ya existe una inscripción activa con la misma fecha de inicio"));
        }
        return Mono.empty();

    }

    private Mono<EnrollmentResponse> saveEnrollment(EnrollmentRequest request, BootcampRef bootcamp) {
        Enrollment enrollment = Enrollment.create(
                request.personId(),
                request.bootcampId(),
                bootcamp.launchdate(),
                bootcamp.duration()
        );
        return enrollmentRepository.save(enrollment)
                .map(mapper::toResponse);
    }

}
