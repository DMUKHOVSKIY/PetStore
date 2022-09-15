package by.tms.petstore.service;

import by.tms.petstore.dao.OrderRepository;
import by.tms.petstore.inMemoryDao.OrderDao;
import by.tms.petstore.entity.Order;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PetService petService;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Map<PetStatus, Integer> inventoryByStatus() {
        Map<PetStatus, Integer> map = new HashMap<>();
        map.put(PetStatus.AVAILABLE, petService.findByStatus(PetStatus.AVAILABLE).size());
        map.put(PetStatus.SOLD, petService.findByStatus(PetStatus.SOLD).size());
        map.put(PetStatus.PENDING, petService.findByStatus(PetStatus.PENDING).size());
        return map;
    }
}
