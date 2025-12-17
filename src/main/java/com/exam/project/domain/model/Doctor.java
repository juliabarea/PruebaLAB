package com.exam.project.domain.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String email;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    public Doctor() {}

    public Doctor(String name, String specialization, String email) {
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getEmail() { return email; }
    public Set<Appointment> getAppointments() { return appointments; }

    public void addAppointment(Appointment a) {
        appointments.add(a);
        a.setDoctor(this);
    }

    public void removeAppointment(Appointment a) {
        appointments.remove(a);
        a.setDoctor(null);
    }

    public boolean hasAppointmentAt(java.time.LocalDateTime dt) {
        return appointments.stream()
            .anyMatch(ap -> ap.getAppointmentDate().equals(dt) && ap.getStatus() != AppointmentStatus.CANCELLED);
    }
}
