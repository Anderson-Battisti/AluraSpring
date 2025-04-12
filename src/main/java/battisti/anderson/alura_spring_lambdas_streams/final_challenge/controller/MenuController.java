package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Brand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
        String vehicleType = requireVehicleType();

        String responseJson = FipeApiController.getInstance().makeRequest( vehicleType, FipeApiController.QueryType.VEHICLE_TYPE ).body();

        List<Brand> brands = getListOfBrandsByJson( responseJson );

        if ( brands == null )
        {
            return;
        }

        printBrands( brands );

        String brandCode = requireBrandCode( brands );
        //todo the rest
    }

    public String requireVehicleType()
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

    public String requireBrandCode( List<Brand> brands )
    {
        Scanner reader = new Scanner( System.in );

        final String[] code   = new String[1];

        System.out.println( "Escolha o código da marca que deseja visualizar os veículos: " );
        code[0] = reader.nextLine();

        while ( ! brands.stream().anyMatch( b -> b.getCode().equals( code[0] ) ) )
        {
            System.out.println( "Código inválido, digite novamente: " );
            code[0] = reader.nextLine();
        }

        return code[0];
    }

    private List<Brand> getListOfBrandsByJson( String json )
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            List<Brand> brands = mapper.readValue( json, new TypeReference<>() {} );

            return brands;
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();

            return null;
        }
    }

    public void printBrands( List<Brand> brands )
    {
        for ( Brand brand : brands )
        {
            System.out.println( brand );
        }
    }
}
