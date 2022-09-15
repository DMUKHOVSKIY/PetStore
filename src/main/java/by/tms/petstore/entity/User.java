package by.tms.petstore.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotEmpty
    @NotBlank
    private String lastName;
    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    private String password;
    @NotEmpty
    @NotBlank
    private String phone;
}
