package com.exam.project.persistence.repositories.projections;

import com.exam.project.domain.model.AppointmentStatus;
import java.time.LocalDateTime;

public interface AppointmentView {
    Long getId();
    LocalDateTime getAppointmentDate();
    AppointmentStatus getStatus();

    Long getDoctorId();
    String getDoctorName();

    Long getPatientId();
    String getPatientName();
}
