package battisti.anderson.alura_data_persistance_and_queries_spring.repository;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    Category findByNameIgnoreCase( String name );
}
