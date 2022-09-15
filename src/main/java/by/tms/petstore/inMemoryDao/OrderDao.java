package by.tms.petstore.inMemoryDao;

import by.tms.petstore.entity.Order;
import by.tms.petstore.statusEnum.PetStatus;

import java.util.Map;
import java.util.Optional;

public interface OrderDao {
    Order save(Order order);

    Optional<Order> findById(Long id);

    Optional<Order> delete(Long id);

    Map<PetStatus, Integer> inventoryByStatus();
}
