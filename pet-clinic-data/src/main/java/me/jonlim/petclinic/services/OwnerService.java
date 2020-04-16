package me.jonlim.petclinic.services;

import me.jonlim.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
