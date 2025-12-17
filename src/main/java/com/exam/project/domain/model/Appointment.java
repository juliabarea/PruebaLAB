package com.exam.project.domain.model;

import jakarta.persistence.*;
import com.exam.project.application.exceptions.BusinessException;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment() {}

    public Appointment(LocalDateTime appointmentDate, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public Long getId() { return id; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public AppointmentStatus getStatus() { return status; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public void cancel() {
        if (this.status != AppointmentStatus.SCHEDULED) {
            throw new BusinessException("Only SCHEDULED appointments can be cancelled");
        }
        this.status = AppointmentStatus.CANCELLED;
    }

    public void setStatus(AppointmentStatus status) { this.status = status; }
}
