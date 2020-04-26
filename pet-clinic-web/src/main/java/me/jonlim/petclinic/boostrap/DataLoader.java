package me.jonlim.petclinic.boostrap;

import me.jonlim.petclinic.model.Owner;
import me.jonlim.petclinic.model.Pet;
import me.jonlim.petclinic.model.PetType;
import me.jonlim.petclinic.model.Vet;
import me.jonlim.petclinic.services.OwnerService;
import me.jonlim.petclinic.services.PetTypeService;
import me.jonlim.petclinic.services.VetService;
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
  public void run(String... args) throws Exception {

    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogType = petTypeService.save(dog);

    PetType cat = new PetType();
    dog.setName("Cat");
    PetType savedCatType = petTypeService.save(cat);

    Owner owner1 = new Owner();
    owner1.setFirstName("Jon");
    owner1.setLastName("Lim");
    owner1.setAddress("1234 S Main");
    owner1.setCity("Salt Lake City");
    owner1.setTelephone("123123123");

    Pet jonPet = new Pet();
    jonPet.setPetType(savedDogType);
    jonPet.setOwner(owner1);
    jonPet.setBirthDate(LocalDate.now());
    jonPet.setName("Butch");
    owner1.getPets().add(jonPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFirstName("Faith");
    owner2.setLastName("Lim");
    owner2.setAddress("1234 S Main");
    owner2.setCity("Salt Lake City");
    owner2.setTelephone("234234234");

    Pet faithsPet = new Pet();
    faithsPet.setName("This cat");
    faithsPet.setOwner(owner2);
    faithsPet.setBirthDate(LocalDate.now());
    faithsPet.setPetType(savedCatType);
    owner2.getPets().add(faithsPet);

    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setFirstName("Spongebob");
    vet1.setLastName("Squarepants");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFirstName("Sandy");
    vet2.setLastName("Squirrel");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }
}
