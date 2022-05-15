package amtech.petclinic.services;

import amtech.petclinic.model.Owner;

public interface OwnerService extends CrudServices<Owner, Long>{

    Owner findByLastName(String lastName);



}
