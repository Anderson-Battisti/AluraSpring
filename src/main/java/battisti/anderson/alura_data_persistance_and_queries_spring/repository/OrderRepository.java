package battisti.anderson.alura_data_persistance_and_queries_spring.repository;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>
{
}
