package by.tms.petstore.entity;

import by.tms.petstore.statusEnum.PetStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Builder
public class Pet {
    private long id;
    @NotNull
    private Category category;
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    private List<Tag> tags;
    @NotNull
    private PetStatus petStatus;
}
