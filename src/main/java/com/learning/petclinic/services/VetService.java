package com.learning.petclinic.services;

import com.learning.petclinic.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet pet);

    Set<Vet> findAll();

}
