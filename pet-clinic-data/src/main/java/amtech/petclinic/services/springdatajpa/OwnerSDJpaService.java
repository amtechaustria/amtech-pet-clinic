package amtech.petclinic.services.springdatajpa;

import amtech.petclinic.model.Owner;
import amtech.petclinic.repositories.OwnerRepository;
import amtech.petclinic.repositories.PetRepository;
import amtech.petclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerRepository {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService( OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }



    @Override
    public <S extends Owner> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Owner> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();

       ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Iterable<Owner> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }


    @Override
    public void deleteAll(Iterable<? extends Owner> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public Owner findAllById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);

        if(optionalOwner.isPresent()){
            return optionalOwner.get();

        } else {
            return null;
    }



    }
}
