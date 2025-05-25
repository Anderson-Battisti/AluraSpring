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
        try
        {
            Product smartphone = new Product( "Smartphone", 1550.99 );
            saveProductIfNotAlreadyAdded( smartphone );

            Product computer = new Product( "Computer", 2000 );
            saveProductIfNotAlreadyAdded( computer );

            Product mouse = new Product( "Mouse", 150.50 );
            saveProductIfNotAlreadyAdded( mouse );

            Category category = new Category( "Electronics" );
            saveCategoryIfNotAlreadyAdded( category );

            Order order = new Order( LocalDate.now() );
            orderRepository.save( order );
        }

        catch ( Exception e )
        {
            System.out.println( "The product already exist in the database. It was ignored." );
        }
    }

    private void saveProductIfNotAlreadyAdded( Product product )
    {
        try
        {
            productRepository.save( product );
        }

        catch ( Exception e )
        {
            System.out.println( "The product already exist in the database. It was ignored." );
        }
    }

    public void saveCategoryIfNotAlreadyAdded( Category category )
    {
        try
        {
            categoryRepository.save( category );
        }

        catch ( Exception e )
        {
            System.out.println( "The category already exist in the database. It was ignored." );
        }
    }
}
