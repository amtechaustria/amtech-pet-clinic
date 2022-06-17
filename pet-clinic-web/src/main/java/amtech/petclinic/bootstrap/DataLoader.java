package amtech.petclinic.bootstrap;

import amtech.petclinic.model.Owner;
import amtech.petclinic.model.Pet;
import amtech.petclinic.model.PetType;
import amtech.petclinic.model.Vet;
import amtech.petclinic.services.OwnerService;
import amtech.petclinic.services.PetTypeService;
import amtech.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import java.sql.SQLOutput;

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
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("122 firestreet");
        owner1.setCity("Miami");
        owner1.setTelephone("421234412");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Testme");
        owner2.setAddress("122 firestreet");
        owner2.setCity("Miami");
        owner2.setTelephone("421234412");
        Pet fionasCat = new Pet();
        fionasCat.setName("kitty cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Max");
        vet1.setLastName("Maier");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Benni");
        vet2.setLastName("Hunter");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
        System.out.println("Look, it is working");

    }
}
