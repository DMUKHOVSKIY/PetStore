package by.tms.petstore.entity;

import by.tms.petstore.statusEnum.OrderStatus;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "storeOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private long petId;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDateTime shipDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @NotNull
    private boolean complete;
}
