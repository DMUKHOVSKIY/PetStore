package by.tms.petstore.service;

import by.tms.petstore.dao.PetDao;
import by.tms.petstore.entity.Pet;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PetService {
    @Autowired
    private PetDao petDao;
    private final AtomicLong atomicLong = new AtomicLong(0);

    public Pet save(Pet pet){
        pet.setId(atomicLong.incrementAndGet());
        return petDao.save(pet);
    }

    public Optional<Pet> update (Pet pet){
        return petDao.update(pet);
    }

    public Optional<List<Pet>> findByStatus(PetStatus petStatus){
        return petDao.findByStatus(petStatus);
    }

    public Optional<Pet> findById(Long id){
        return petDao.findPetById(id);
    }

    public Optional<Pet> updatePetById(Long id, String name, PetStatus petStatus){
        return petDao.updatePetById(id, name, petStatus);
    }

    public Optional<Pet> deletePetById(Long id){
        return petDao.deletePetById(id);
    }
}
