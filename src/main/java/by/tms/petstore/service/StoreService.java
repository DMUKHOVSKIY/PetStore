package by.tms.petstore.service;

import by.tms.petstore.dao.StoreDao;
import by.tms.petstore.entity.Order;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StoreService {
    @Autowired
    private StoreDao storeDao;
    private AtomicLong atomicLong = new AtomicLong(0);

    public Order save(Order order) {
        order.setId(atomicLong.incrementAndGet());
        return storeDao.save(order);
    }

    public Optional<Order> findById(Long id){
        return storeDao.findById(id);
    }

    public Optional<Order> delete(Long id){
        return storeDao.delete(id);
    }

    public Optional<Map<PetStatus, Integer>> inventoryByStatus(){
        return storeDao.inventoryByStatus();
    }
}
