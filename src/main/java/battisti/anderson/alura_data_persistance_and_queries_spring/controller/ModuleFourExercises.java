package battisti.anderson.alura_data_persistance_and_queries_spring.controller;

import battisti.anderson.alura_data_persistance_and_queries_spring.model.Category;
import battisti.anderson.alura_data_persistance_and_queries_spring.model.Product;
import battisti.anderson.alura_data_persistance_and_queries_spring.repository.CategoryRepository;
import battisti.anderson.alura_data_persistance_and_queries_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ModuleFourExercises
{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public void createAndSaveCategory()
    {
        Category category = new Category( "Furniture" );

        saveCategoryIfNotAlreadyAdded( category );
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

    public void showProductsByName()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter the name of the product to fetch it: " );

        String productName = reader.nextLine();

        Product product = productRepository.findByNameIgnoreCase( productName );

        if ( product == null )
        {
            System.out.println( "The product " + productName + " does not exist in the database. " );
        }

        else
        {
            System.out.println( "Product found: " + product );
        }
    }

    public void showProductsByCategory()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter the name of the category to fetch the products: " );

        String categoryName = reader.nextLine();

        Category category = categoryRepository.findByNameIgnoreCase( categoryName );

        List<Product> products = productRepository.findByCategory( category );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found by the category: " + categoryName );
        }

        else
        {
            System.out.println( "Products of this category: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductsByPriceGreaterThanValue()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter minimum price to fetch the products: " );

        double minPrice = reader.nextDouble();

        List<Product> products = productRepository.findByPriceGreaterThan( minPrice );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found above this price: " + minPrice );
        }

        else
        {
            System.out.println( "Products above this price: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductsByPriceLessThanValue()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter maximum price to fetch the products: " );

        double maxPrice = reader.nextDouble();

        List<Product> products = productRepository.findByPriceLessThan( maxPrice );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found bellow this price: " + maxPrice );
        }

        else
        {
            System.out.println( "Products below this price: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductsByNameContaining()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter a part of the name to fetch the products: " );

        String productName = reader.nextLine();

        List<Product> products = productRepository.findByNameContainingIgnoreCase( productName );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found containing this text: " + productName );
        }

        else
        {
            System.out.println( "Products found: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductByCategoryOrdeningByAscPrice()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter the category to fetch the products: " );

        String categoryName = reader.nextLine();

        List<Product> products = productRepository.findByCategoryOrderByPriceAsc( categoryName );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found for the category: " + categoryName );
        }

        else
        {
            System.out.println( "Products found: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductByCategoryOrdeningByPriceDesc()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter the category to fetch the products: " );

        String categoryName = reader.nextLine();

        List<Product> products = productRepository.findByCategoryOrderByPriceDesc( categoryName );

        if ( products.isEmpty() )
        {
            System.out.println( "No products were found for the category: " + categoryName );
        }

        else
        {
            System.out.println( "Products found: " );

            products.forEach( System.out::println );
        }
    }

    public void showProductCountByCategory()
    {
        Scanner reader = new Scanner(System.in);

        System.out.println( "Enter the category to count the products: " );

        String categoryName = reader.nextLine();

        Integer productCount = productRepository.countByCategory( categoryName );

        if ( productCount == null )
        {
            System.out.println( "No products were found for the category: " + categoryName );
        }

        else
        {
            System.out.println("Products found in this category: " + productCount );
        }
    }

    public void showProductCountByPriceGreaterThan()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Enter minimum price to count the products: " );

        double minPrice = reader.nextDouble();

        Integer productsCount = productRepository.countByPriceGreaterThan( minPrice );

        if ( productsCount == null )
        {
            System.out.println( "No products were found bellow this price: " + minPrice );
        }

        else
        {
            System.out.println( "Products above this price: " + productsCount );
        }
    }
}
