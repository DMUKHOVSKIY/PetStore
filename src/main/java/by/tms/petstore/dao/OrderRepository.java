package by.tms.petstore.dao;

import by.tms.petstore.entity.Order;
import by.tms.petstore.statusEnum.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
