package com.learning.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Vet extends Person {

    private Set<Speciality> speciality = new HashSet<>();
}
