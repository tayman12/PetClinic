package com.learning.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet extends BaseEntity {

    private PetType type;
    private Owner owner;
    private LocalDate birthday;
}
