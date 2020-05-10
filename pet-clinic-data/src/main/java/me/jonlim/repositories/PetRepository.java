package me.jonlim.repositories;

import me.jonlim.petclinic.model.Pet;
import me.jonlim.petclinic.services.CrudService;

public interface PetRepository extends CrudService<Pet, Long> {
}
