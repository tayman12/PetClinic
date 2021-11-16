package com.learning.petclinic.services;

import com.learning.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
