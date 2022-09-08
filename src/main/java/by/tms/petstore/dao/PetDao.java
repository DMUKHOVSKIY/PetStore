package by.tms.petstore.dao;

import by.tms.petstore.entity.Pet;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PetDao {
    Pet save(Pet pet);

    Optional<Pet> update(Pet pet);

    Optional<List<Pet>> findByStatus(PetStatus petStatus);

    Optional<Pet> findPetById(Long petId);

    Optional<Pet> updatePetById(Long id, String name, PetStatus petStatus);

    Optional<Pet> deletePetById(Long id);

}
