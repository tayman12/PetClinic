package com.learning.petclinic.services;

import com.learning.petclinic.model.Vet;
import org.springframework.stereotype.Service;

@Service
public interface VetService extends CrudService<Vet, Long> {
}
