package battisti.anderson.alura_spring_lambdas_streams.controller;

import battisti.anderson.alura_spring_lambdas_streams.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductController
{
    private static ProductController productController;

    private ProductController() {}

    public static ProductController getInstance()
    {
        if ( productController == null ) productController = new  ProductController();

        return productController;
    }

    public void separateProductsByCategory()
    {
        Map<String, List<Product>> productsByCategory = Product.getProducts()
                                                               .stream()
                                                               .collect( Collectors.groupingBy( Product::getCategory ) );

        System.out.println( productsByCategory );
    }

    public void countProductsByCategory()
    {
        Map<String, Long> amountPerCategory = Product.getProducts()
                                                     .stream()
                                                     .collect( Collectors.groupingBy( Product::getCategory, Collectors.counting() ) );

        System.out.println( amountPerCategory );
    }

    public void identifyMostExpensiveProductOfEachCategory()
    {
        Map<String, Optional<Product>> mostExpensiveProductOfEachCategory = Product.getProducts()
                                                                                   .stream()
                                                                                   .collect( Collectors.groupingBy( Product::getCategory,
                                                                                             Collectors.maxBy( Comparator.comparingDouble( Product::getPrice ) ) ) );

        System.out.println( mostExpensiveProductOfEachCategory );
    }

    public void sumPricesByCategory()
    {
        Map<String, Double> totalPricesByCategory = Product.getProducts()
                                                           .stream()
                                                           .collect( Collectors.groupingBy( Product::getCategory,
                                                                     Collectors.summingDouble( Product::getPrice ) ) );

        System.out.println( totalPricesByCategory );
    }
}
