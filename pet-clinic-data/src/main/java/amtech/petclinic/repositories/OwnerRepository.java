package amtech.petclinic.repositories;

import amtech.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    Owner findAllById(Long aLong);
}
