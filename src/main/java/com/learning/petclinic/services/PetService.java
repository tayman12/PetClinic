package com.learning.petclinic.services;

import com.learning.petclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Pet, Long> {
}
