package by.tms.petstore.controller;

import by.tms.petstore.entity.Pet;
import by.tms.petstore.service.PetService;
import by.tms.petstore.statusEnum.PetStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
@Tag(name= "pet", description = "Everything about your Pets")
public class PetController {

    private final PetService petService;

    public PetController (PetService petService){
        this.petService = petService;
    }

    @PostMapping
    @Operation(summary = "Add a new pet to the store")
    public ResponseEntity<Pet> addNewPet(@RequestBody @Valid Pet pet) {
        return new ResponseEntity<>(petService.save(pet), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update an existing pet" )
    public ResponseEntity<Pet> updatePet(@RequestBody @Valid Pet pet) {
        Optional<Pet> update = petService.update(pet);
        if(update.isPresent()){
            return ResponseEntity.ok(update.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findByStatus")
    @Operation(summary = "Finds Pets By status", description = "Multiple status values can be provided with comma separated strings")
    public ResponseEntity<List<Pet>> findPetsByStatus(PetStatus status) {
        Optional<List<Pet>> byStatus = petService.findByStatus(status);
        if(byStatus.isPresent()){
            return ResponseEntity.ok(byStatus.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{petId}")
    @Operation(summary = "Find Pet by ID", description = "Returns a single pet")
    public ResponseEntity<Pet> findPetById(@PathVariable Long petId) {
        Optional<Pet> byId = petService.findById(petId);
        if(byId.isPresent()){
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/{petId}")
    @Operation(summary = "Update a pet in the store with form data")
    public ResponseEntity<Pet> updatePetById(@PathVariable Long petId, String name, PetStatus status) {
        Optional<Pet> pet = petService.updatePetById(petId, name, status);
        if(pet.isPresent()){
            return ResponseEntity.ok(pet.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{petId}")
    @Operation(summary = "Deletes a pet")
    public ResponseEntity<Pet> deletePetById(@PathVariable Long petId) {
        Optional<Pet> pet = petService.deletePetById(petId);
        if(pet.isPresent()){
            return ResponseEntity.ok(pet.get());
        }
        return ResponseEntity.badRequest().build();
    }

}
