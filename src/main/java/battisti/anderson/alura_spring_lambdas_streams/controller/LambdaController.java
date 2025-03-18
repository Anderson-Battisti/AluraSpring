package battisti.anderson.alura_spring_lambdas_streams.controller;

import battisti.anderson.alura_spring_lambdas_streams.interfaces.IMultiplication;
import battisti.anderson.alura_spring_lambdas_streams.interfaces.IPalindromeChecker;
import battisti.anderson.alura_spring_lambdas_streams.interfaces.IPrimeNumber;
import battisti.anderson.alura_spring_lambdas_streams.interfaces.IStringToUpperCaseConverter;

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
}
