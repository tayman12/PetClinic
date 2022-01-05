package com.learning.petclinic.services;

import com.learning.petclinic.model.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialityService extends CrudService<Speciality, Long> {
}
