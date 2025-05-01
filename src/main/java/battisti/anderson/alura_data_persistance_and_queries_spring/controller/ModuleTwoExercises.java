package battisti.anderson.alura_data_persistance_and_queries_spring.controller;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Category;
import battisti.anderson.alura_data_persistance_and_queries_spring.model.Order;
import battisti.anderson.alura_data_persistance_and_queries_spring.model.Product;
import battisti.anderson.alura_data_persistance_and_queries_spring.repository.CategoryRepository;
import battisti.anderson.alura_data_persistance_and_queries_spring.repository.OrderRepository;
import battisti.anderson.alura_data_persistance_and_queries_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ModuleTwoExercises
{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    public void createAndSaveEachObjectInDatabase()
    {
        Product product = new Product( "Smartphone", 1550.99 );
        productRepository.save( product );

        Category category = new Category( "Electronics" );
        categoryRepository.save( category );

        Order order = new Order( LocalDate.now() );
        orderRepository.save( order );
    }
}
