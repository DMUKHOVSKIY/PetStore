package by.tms.petstore.entity;

import by.tms.petstore.statusEnum.OrderStatus;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@Builder
public class Order {
    private long id;
    @NotNull
    private long petId;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDateTime shipDate;
    @NotNull
    private OrderStatus orderStatus;
    @NotNull
    private boolean complete;
}
