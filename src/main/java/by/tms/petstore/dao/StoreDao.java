package by.tms.petstore.dao;

import by.tms.petstore.entity.Order;
import by.tms.petstore.statusEnum.PetStatus;

import java.util.Map;
import java.util.Optional;

public interface StoreDao {
    Order save(Order order);
    Optional<Order> findById(Long id);
    Optional<Order> delete(Long id);
    Optional<Map<PetStatus,Integer>> inventoryByStatus();
}
