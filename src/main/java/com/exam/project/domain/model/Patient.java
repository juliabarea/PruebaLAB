package com.exam.project.domain.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Appointment> appointments = new HashSet<>();

    public Patient() {}

    public Patient(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public Set<Appointment> getAppointments() { return appointments; }

    public void addAppointment(Appointment a) {
        appointments.add(a);
        a.setPatient(this);
    }

    public void removeAppointment(Appointment a) {
        appointments.remove(a);
        a.setPatient(null);
    }
}
