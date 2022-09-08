package by.tms.petstore.dao;

import by.tms.petstore.entity.Pet;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryPetDao implements PetDao{
    private List<Pet> petList = new ArrayList<>();


    @Override
    public Pet save(Pet pet) {
        petList.add(pet);
        return pet;
    }

    @Override
    public Optional<Pet> update(Pet pet) {
        for (int i = 0; i < petList.size(); i++) {
            if(petList.get(i).getId() == (pet.getId())){
                petList.set(i,pet);
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Pet>> findByStatus(PetStatus petStatus) {
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : petList) {
            if(pet.getPetStatus().equals(petStatus)){
                pets.add(pet);
            }
        }
        return Optional.ofNullable(pets);
    }

    @Override
    public Optional<Pet> findPetById(Long petId) {
        for (Pet pet : petList) {
            if(pet.getId() == petId){
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> updatePetById(Long id, String name, PetStatus petStatus) {
        for (Pet pet : petList) {
            if(pet.getId() == id){
                pet.setName(name);
                pet.setPetStatus(petStatus);
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Pet> deletePetById(Long id) {
        for (Pet pet : petList) {
            if(pet.getId() == id){
                petList.remove(pet);
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }
}
