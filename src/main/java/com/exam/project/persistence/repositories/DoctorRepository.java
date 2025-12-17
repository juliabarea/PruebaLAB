package com.exam.project.persistence.repositories;

import com.exam.project.domain.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}

