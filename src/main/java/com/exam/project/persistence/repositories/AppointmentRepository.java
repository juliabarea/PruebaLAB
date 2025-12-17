package com.exam.project.persistence.repositories;

import com.exam.project.domain.model.Appointment;
import com.exam.project.domain.model.AppointmentStatus;
import com.exam.project.persistence.repositories.projections.AppointmentView;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    boolean existsByDoctorIdAndAppointmentDateAndStatusNot(Long doctorId, LocalDateTime appointmentDate, AppointmentStatus status);
    List<AppointmentView> findByDoctorId(Long doctorId);
    List<AppointmentView> findByPatientId(Long patientId);
    Optional<AppointmentView> findProjectedById(Long id);
}
