package by.tms.petstore.controller;

import by.tms.petstore.entity.Order;
import by.tms.petstore.service.OrderService;
import by.tms.petstore.statusEnum.PetStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@Tag(name = "store", description = "Access to Petstore orders")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    @Operation(summary = "Place an order for a pet")
    public ResponseEntity<Order> PlaceAnOrder(@RequestBody @Valid Order order) {
        Order save = service.save(order);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("/order/{orderId}")
    @Operation(summary = "Find purchase order by ID", description = "For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions")
    public ResponseEntity<Order> findOrderById(@PathVariable Long orderId) {
        Optional<Order> byId = service.findById(orderId);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/order/{orderId}")
    @Operation(summary = "Delete purchase order by ID", description = "For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors")
    public ResponseEntity<Order> deleteOrder(@PathVariable Long orderId) {
        service.delete(orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inventory")
    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities")
    public ResponseEntity<Map<PetStatus, Integer>> inventoryByStatus() {
        Map<PetStatus, Integer> petStatusIntegerMap = service.inventoryByStatus();
        if (!petStatusIntegerMap.isEmpty()) {
            return ResponseEntity.ok(petStatusIntegerMap);
        }
        return ResponseEntity.notFound().build();
    }
}
