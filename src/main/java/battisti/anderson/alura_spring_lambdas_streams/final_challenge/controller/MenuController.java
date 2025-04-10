package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import java.util.Scanner;

public class MenuController
{
    private static MenuController menuController;

    public static MenuController getInstance()
    {
        if ( menuController == null ) menuController = new MenuController();

        return menuController;
    }

    public void runMenu()
    {
        Integer userChoice = null;
        String  veihcleType = requireInput();
        FipeApiController.makeRequest( veihcleType );
    }

    public String requireInput()
    {
        Scanner reader        = new Scanner( System.in );
        String  vehicleChoice = null;

        System.out.println( "Opções: Carros, Motos, Caminhoes" );
        System.out.println( "\n Digite uma das opções para consultar valores: " );

        while ( vehicleChoice == null || ( ! vehicleChoice.equals( "carros" ) &&
                                           ! vehicleChoice.equals( "motos" )  &&
                                           ! vehicleChoice.equals( "caminhoes" ) ) )
        {
            vehicleChoice = reader.nextLine().toLowerCase();
        }

        return vehicleChoice;
    }
}
