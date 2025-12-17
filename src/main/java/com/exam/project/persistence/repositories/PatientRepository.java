package com.exam.project.persistence.repositories;

import com.exam.project.domain.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}

