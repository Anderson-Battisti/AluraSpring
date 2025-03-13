package battisti.anderson.alura_spring_lambdas_streams;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CountController
{
    public static void countUntilUserChoice()
    {
        Scanner input = new Scanner( System.in );

        System.out.println( "Write the number you want to count until it: " );

        try
        {
            int number = input.nextInt();

            for ( int i = 1; i <= number; i++ )
            {
                System.out.println( i );
            }
        }

        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
