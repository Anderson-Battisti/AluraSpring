package battisti.anderson.alura_spring_lambdas_streams.controller;

import battisti.anderson.alura_spring_lambdas_streams.interfaces.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaController
{
    private static LambdaController instance;

    public static LambdaController getInstance()
    {
        if ( instance == null )
        {
            instance = new LambdaController();
        }

        return instance;
    }

    public void multiply()
    {
        IMultiplication multiplication = ( a, b ) -> a + b;

        System.out.println( multiplication.multiply( 5, 6 ) );
    }

    public void checkPrimeNumber()
    {
        IPrimeNumber primeNumberChecker = ( n ) ->
        {
            if ( n <= 1 ) return false;

            for ( int i = 2; i <= Math.sqrt( n ); i++ )
            {
                if ( n % i == 0 ) return false;
            }

            return true;
        };

        boolean isPrimeNumber = primeNumberChecker.checkPrimeNumber( 12 );

        System.out.println( isPrimeNumber ? "The number is prime." : "The number isn't prime." );
    }

    public void stringToUpperCase()
    {
        IStringToUpperCaseConverter converter = ( str ) -> { return str.toUpperCase(); };

        System.out.println( converter.toUpperCase( "This is a string to be converted." ) );
    }

    public void palindromeChecker()
    {
        IPalindromeChecker palindromeChecker = ( str ) ->
        {
            return str.toUpperCase().equalsIgnoreCase( new StringBuilder( str ).reverse().toString() );
        };

        System.out.println( palindromeChecker.isPalindrome( "Ovo" ) );
    }

    public void multiplyArrayOfNumbers()
    {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );

        numbers.replaceAll( n -> n * 3 );

        System.out.println( numbers );
    }

    public void sortStrings()
    {
        List<String> strings = Arrays.asList( "Palavra", "Teste", "Computador", "Software", "Engenharia", "Análise" );
        Collections.sort( strings );
        System.out.println( strings );
    }

    public void divideNumbers()
    {
        IDivideNumbers divideNumbers = ( n1, n2 ) ->
        {
            if ( n2 == 0 ) throw new ArithmeticException( "Division by zero" );
            return n1 / n2;
        };

        double n1 = 5.5;
        double n2 = 0;

        try
        {
            System.out.println( divideNumbers.divideNumbers( n1, n2 ) );
        }

        catch ( ArithmeticException e )
        {
            System.out.println( e.getMessage() );
        }
    }
}
