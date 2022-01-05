package com.learning.petclinic.bootstrap;

import com.learning.petclinic.model.*;
import com.learning.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {
        int petsCount = petService.findAll().size();

        if (petsCount == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Tocka");
        owner1.setLastName("Ayman");
        owner1.setAddress("5th Settlement");
        owner1.setCity("Cairo");
        owner1.setTelephone("01111111111");

        Pet mike = new Pet();
        mike.setType(savedDogType);
        mike.setBirthday(LocalDate.now());
        mike.setOwner(owner1);
        mike.setName("Mike");

        owner1.getPets().add(mike);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shrouk");
        owner2.setLastName("Fathy");
        owner2.setAddress("6th of October");
        owner2.setCity("Giza");
        owner2.setTelephone("02222222222");

        Pet lolo = new Pet();
        lolo.setType(savedCatType);
        lolo.setBirthday(LocalDate.now());
        lolo.setOwner(owner2);
        lolo.setName("lolo");

        owner2.getPets().add(lolo);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Bosy");
        vet1.setLastName("Samy");
        vet1.getSpeciality().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ahmed");
        vet2.setLastName("Magdy");
        vet1.getSpeciality().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Data is loaded...");
    }
}
