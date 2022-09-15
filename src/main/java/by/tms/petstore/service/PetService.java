package by.tms.petstore.service;

import by.tms.petstore.dao.PetRepository;
import by.tms.petstore.entity.Pet;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet update(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findByStatus(PetStatus petStatus) {
        return petRepository.findByPetStatusOrderByNameAsc(petStatus);
    }

    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }


    @Transactional
    public void updatePetById(Long id, String name, PetStatus petStatus) {
     petRepository.updatePetById(id, name, petStatus);
    }

    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }
}
