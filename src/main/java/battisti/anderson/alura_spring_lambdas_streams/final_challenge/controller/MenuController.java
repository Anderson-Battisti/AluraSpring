package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Brand;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpResponse;
import java.util.List;
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
        String  veihcleType = requireFirstInput();

        String responseJson = FipeApiController.getInstance().makeRequest( veihcleType, FipeApiController.QueryType.VEHICLE_TYPE ).body();

        ObjectMapper mapper = new ObjectMapper();
        //todo
        //List<Brand> brands = mapper.readValue( json,  );
    }

    public String requireFirstInput()
    {
        Scanner reader        = new Scanner( System.in );
        String  vehicleChoice = null;

        System.out.println( "\nOpções: Carros, Motos, Caminhoes" );
        System.out.println( "Digite uma das opções para consultar valores: " );

        vehicleChoice = reader.nextLine().toLowerCase();

        while ( vehicleChoice == null || ( ! vehicleChoice.equals( "carros" ) &&
                                           ! vehicleChoice.equals( "motos" )  &&
                                           ! vehicleChoice.equals( "caminhoes" ) ) )
        {
            System.out.println( "Opção inválida, digite novamente: " );
            vehicleChoice = reader.nextLine().toLowerCase();
        }

        return vehicleChoice;
    }
}
