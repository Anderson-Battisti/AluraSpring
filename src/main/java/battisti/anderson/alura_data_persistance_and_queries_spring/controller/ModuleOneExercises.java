package battisti.anderson.alura_data_persistance_and_queries_spring.controller;

import java.util.Arrays;
import java.util.List;

public class ModuleOneExercises
{
    private static ModuleOneExercises instance;

    public static ModuleOneExercises getInstance()
    {
        if ( instance == null ) instance = new ModuleOneExercises();

        return instance;
    }

    public void convertStringToNumber()
    {
        List<String> input = Arrays.asList( "10", "abc", "20", "30x" );

        input.stream().filter( n ->
        {
            try
            {
                Integer.parseInt( n );
                return true;
            }
            catch ( NumberFormatException e )
            {
                return false;
            }
        }).forEach( System.out::println );
    }

    public void printFirstAndLastName()
    {
        String completeName = "Anderson Gabriel Battisti";
        String firstName    = "";
        String lastName     = "";

        for ( int i = 0; i < completeName.length(); i++ )
        {
            if ( completeName.charAt( i ) == ' ' ) break;

            firstName += completeName.charAt( i );
        }

        for ( int i = completeName.length() - 1; i > -1; i-- )
        {
            if ( completeName.charAt( i ) == ' ' ) break;

            lastName = completeName.charAt( i ) + lastName;
        }

        System.out.println( firstName.equals( lastName ) ? firstName :
                                                           firstName + " " + lastName );
    }
}
