package com.learning.petclinic.bootstrap;

import com.learning.petclinic.model.Owner;
import com.learning.petclinic.model.Pet;
import com.learning.petclinic.model.PetType;
import com.learning.petclinic.model.Vet;
import com.learning.petclinic.services.OwnerService;
import com.learning.petclinic.services.PetTypeService;
import com.learning.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ahmed");
        vet2.setLastName("Magdy");

        vetService.save(vet2);

        System.out.println("Data is loaded...");
    }
}
