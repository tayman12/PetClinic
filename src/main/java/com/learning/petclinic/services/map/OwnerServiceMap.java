package com.learning.petclinic.services.map;

import com.learning.petclinic.model.Owner;
import com.learning.petclinic.model.Pet;
import com.learning.petclinic.services.CrudService;
import com.learning.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>, OwnerService {

    private final PetServiceMap petServiceMap;
    private final PetTypeServiceMap petTypeServiceMap;

    public OwnerServiceMap(PetServiceMap petServiceMap, PetTypeServiceMap petTypeServiceMap) {
        this.petServiceMap = petServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getType() != null) {
                        if (pet.getType().getId() == null) {
                            pet.setType(petTypeServiceMap.save(pet.getType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petServiceMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
