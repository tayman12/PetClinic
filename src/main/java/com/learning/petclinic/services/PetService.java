package com.learning.petclinic.services;

import com.learning.petclinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
