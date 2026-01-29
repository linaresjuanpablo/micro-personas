package com.example.personas.infra.output.mapper;

import com.example.personas.domain.model.Enrollment;
import com.example.personas.infra.input.dto.EnrollmentResponse;
import com.example.personas.infra.output.r2dbc.entity.EnrollmentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

public class EnrollmentMapper {

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        return new EnrollmentResponse(
                enrollment.getId(),
                enrollment.getPersonId(),
                enrollment.getBootcampId(),
                enrollment.getStatus(),
                enrollment.getLaunchdate(),
                enrollment.getDuration(),
                enrollment.getCreatedAt()
        );
    }

    public EnrollmentEntity toEntity(Enrollment enrollment) {
        return new EnrollmentEntity(
                enrollment.getId(),
                enrollment.getPersonId(),
                enrollment.getBootcampId(),
                enrollment.getStatus(),
                enrollment.getLaunchdate(),
                enrollment.getDuration(),
                enrollment.getCreatedAt()
        );
    }

    public Enrollment toDomain(EnrollmentEntity entity) {
        return new Enrollment(
                entity.getId(),
                entity.getPersonId(),
                entity.getBootcampId(),
                entity.getStatus(),
                entity.getLaunchdate(),
                entity.getDuration(),
                entity.getCreatedAt()
        );
    }



}
