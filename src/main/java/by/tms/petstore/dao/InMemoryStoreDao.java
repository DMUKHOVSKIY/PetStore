package by.tms.petstore.dao;

import by.tms.petstore.entity.Order;
import by.tms.petstore.service.PetService;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryStoreDao implements StoreDao {

    @Autowired
    private PetService petService;

    private List<Order> orderList = new ArrayList<>();

    @Override
    public Order save(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        for (Order order : orderList) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> delete(Long id) {
        for (Order order1 : orderList) {
            if (order1.getId() == id) {
                orderList.remove(order1);
                return Optional.of(order1);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Map<PetStatus, Integer>> inventoryByStatus() {
        Map<PetStatus, Integer> map = new HashMap<>();
        map.put(PetStatus.AVAILABLE, petService.findByStatus(PetStatus.AVAILABLE).get().size());
        map.put(PetStatus.PENDING, petService.findByStatus(PetStatus.PENDING).get().size());
        map.put(PetStatus.SOLD, petService.findByStatus(PetStatus.SOLD).get().size());
        return Optional.ofNullable(map);
    }
}
