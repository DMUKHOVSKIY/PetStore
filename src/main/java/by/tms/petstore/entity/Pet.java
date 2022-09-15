package by.tms.petstore.entity;

import by.tms.petstore.statusEnum.PetStatus;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PetStatus petStatus;
}
