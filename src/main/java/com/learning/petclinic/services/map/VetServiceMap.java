package com.learning.petclinic.services.map;

import com.learning.petclinic.model.Speciality;
import com.learning.petclinic.model.Vet;
import com.learning.petclinic.services.CrudService;
import com.learning.petclinic.services.SpecialityService;
import com.learning.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("map")
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long>, VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            if (vet.getSpeciality() != null) {
                vet.getSpeciality().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(vet);
        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
