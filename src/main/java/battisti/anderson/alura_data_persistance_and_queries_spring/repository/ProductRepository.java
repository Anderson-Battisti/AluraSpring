package battisti.anderson.alura_data_persistance_and_queries_spring.repository;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{
}
