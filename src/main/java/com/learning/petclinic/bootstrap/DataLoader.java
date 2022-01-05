package com.learning.petclinic.bootstrap;

import com.learning.petclinic.model.Owner;
import com.learning.petclinic.model.PetType;
import com.learning.petclinic.model.Vet;
import com.learning.petclinic.services.OwnerService;
import com.learning.petclinic.services.PetTypeService;
import com.learning.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shrouk");
        owner2.setLastName("Fathy");

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
