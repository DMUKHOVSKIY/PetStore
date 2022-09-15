package by.tms.petstore.dao;

import by.tms.petstore.entity.Pet;
import by.tms.petstore.statusEnum.PetStatus;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByPetStatusOrderByNameAsc(PetStatus petStatus);

    @Query(value = "update Pet p set p.name = :name, p.petStatus = :petStatus where p.id = :id")
    @Modifying
    void updatePetById(Long id, String name, PetStatus petStatus);
}
