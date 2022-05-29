package amtech.petclinic.bootstrap;

import amtech.petclinic.model.Owner;
import amtech.petclinic.model.Vet;
import amtech.petclinic.services.OwnerService;
import amtech.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Testme");

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

    }
}
