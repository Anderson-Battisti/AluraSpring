package battisti.anderson.alura_data_persistance_and_queries_spring.repository;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Category;
import battisti.anderson.alura_data_persistance_and_queries_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product findByNameIgnoreCase(String name );

    List<Product> findByCategory( Category category );

    List<Product> findByPriceGreaterThan( double price );

    List<Product> findByPriceLessThan( double price );
}
