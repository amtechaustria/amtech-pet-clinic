package amtech.petclinic.services;
import amtech.petclinic.model.Pet;

import java.util.Set;

public interface PetService {


    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();


}