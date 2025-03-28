package battisti.anderson.alura_spring_lambdas_streams.controller;

import battisti.anderson.alura_spring_lambdas_streams.model.Person;
import battisti.anderson.alura_spring_lambdas_streams.model.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class StreamController
{
    private static StreamController instance;

    private StreamController()
    {}

    public static StreamController getInstance()
    {
        if ( instance == null ) instance = new StreamController();

        return instance;
    }

    public void filterNumbers()
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );

        numbers.stream().filter(  n -> n % 2 == 0 )
                        .forEach( System.out::println );
    }

    public void stringToUpperCase()
    {
        List<String> strings = Arrays.asList( "java",
                                              "lambda",
                                              "stream" );

        strings.stream().map( s -> s.toUpperCase() )
                        .forEach( System.out::println );
    }

    public void oddNumbersMultiplicator()
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );

        List<Integer> updatedNumbers = numbers.stream().filter( n -> n % 2 != 0 )
                                                       .map( n -> n * 2 )
                                                       .toList();
        System.out.println( updatedNumbers );
    }

    public void duplicatedRemover()
    {
        List<String> words = Arrays.asList( "apple",
                                            "banana",
                                            "apple",
                                            "orange",
                                            "banana" );

        List<String> filteredWords = words.stream()
                                          .distinct()
                                          .toList();

        System.out.println( filteredWords );
    }

    public void primeNumberExtractor()
    {
        List<List<Integer>> numberLists = Arrays.asList( Arrays.asList( 1, 2, 3, 4 ),
                                                         Arrays.asList( 5, 6, 7, 8 ),
                                                         Arrays.asList( 9, 10, 11, 12 ) );

        List<Integer> primeSortedNumbers = numberLists.stream()
                                                      .flatMap( List::stream )
                                                      .filter(  this::isPrime )
                                                      .sorted()
                                                      .toList();
        System.out.println( primeSortedNumbers );
    }

    public void getAdults()
    {
        List<Person> people = Arrays.asList( new Person( "Jessica",  21 ),
                                             new Person( "Bob",      15 ),
                                             new Person( "Anderson", 25 ),
                                             new Person( "Ted",      8  ) );

        people.stream()
              .filter( p -> p.getAge() >= 18 )
              .map(    p -> p.getName()      )
              .sorted()
              .forEach( System.out::println );
    }

    public void filterProducts()
    {
        List<Product> products = Arrays.asList( new Product( "Smartphone", 800.0,  Product.Category.ELECTRONICS ),
                                                new Product( "Notebook",   1500.0, Product.Category.ELECTRONICS ),
                                                new Product( "Teclado",    200.0,  Product.Category.ELECTRONICS ),
                                                new Product( "Cadeira",    300.0,  Product.Category.HOME ),
                                                new Product( "Monitor",    900.0,  Product.Category.ELECTRONICS ),
                                                new Product( "Mesa",       700.0,  Product.Category.HOME ) );

        List<Product> filteredProducts = products.stream()
                                                 .filter( p -> ( p.getCategory().equals( Product.Category.ELECTRONICS ) && p.getPrice() < 1000 ) )
                                                 .sorted( Comparator.comparingDouble( Product::getPrice ) )
                                                 .toList();

        System.out.println( filteredProducts );

        products.stream().filter( p -> p.getCategory().equals( Product.Category.ELECTRONICS ) )
                         .sorted( Comparator.comparingDouble( Product::getPrice ) )
                         .limit( 3 )
                         .forEach( System.out::println );
    }

    private boolean isPrime( int number )
    {
        if ( number <= 1 ) return false;

        return IntStream.rangeClosed( 2, (int) Math.sqrt( number ) )
                        .noneMatch( i -> number % i == 0 );
    }
}
