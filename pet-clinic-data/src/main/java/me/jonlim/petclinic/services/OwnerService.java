package me.jonlim.petclinic.services;

import me.jonlim.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
