package me.jonlim.petclinic.services;

import me.jonlim.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

  Vet findById(Long id);

  Vet save(Vet vet);

  Set<Vet> findAll();

}
