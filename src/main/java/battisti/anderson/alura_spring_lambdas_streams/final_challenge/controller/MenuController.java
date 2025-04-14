package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Brand;
import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Model;
import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

        List<Brand> brands = getListOfBrands( FipeApiController.getInstance()
                                                               .makeRequest( vehicleType, FipeApiController.QueryType.VEHICLE )
                                                               .body() );

        if ( brands == null )
        {
            return;
        }

        printsEachItem( brands );

        String brandCode = requireBrandCode( brands );

        List<Model> models = getListOfModels( FipeApiController.getInstance()
                                                               .makeRequest( vehicleType, brandCode, FipeApiController.QueryType.MODEL )
                                                               .body() );

        if ( models == null )
        {
            return;
        }

        printsEachItem( models );

        /*String modelCode = requireModelCode( models );

        List<Vehicle> vehicles =
        //todo the rest*/
    }

    public String requireVehicleType()
    {
        Scanner reader = new Scanner( System.in );

        String vehicleChoice = null;

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

        final String[] code = new String[1];

        System.out.println( "Escolha o código da marca que deseja visualizar os veículos: " );
        code[0] = reader.nextLine();

        while ( brands.stream().noneMatch( b -> b.getCode().equals( code[0] ) ) )
        {
            System.out.println( "Código inválido, digite novamente: " );
            code[0] = reader.nextLine();
        }

        return code[0];
    }

    private String requireModelCode( List<Model> models )
    {
        Scanner reader = new Scanner( System.in );

        final String[] code = new String[1];

        System.out.println( "Escolha o código do modelo que deseja visualizar: " );
        code[0] = reader.nextLine();

        while ( models.stream().noneMatch( b -> b.getCode().equals( code[0] ) ) )
        {
            System.out.println( "Código inválido, digite novamente: " );
            code[0] = reader.nextLine();
        }

        return code[0];
    }

    private List<Brand> getListOfBrands( String json )
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

    private List<Model> getListOfModels( String json )
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            List<Model> models = mapper.readValue( json, new TypeReference<>() {} );

            return models;
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();

            return null;
        }
    }

    private List<Model> getListOfVehicles( String json )
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            List<Model> vehicles = mapper.readValue( json, new TypeReference<>() {} );

            return vehicles;
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();

            return null;
        }
    }

    public <T> void printsEachItem( List<T> items )
    {
        for ( T item : items )
        {
            System.out.println( item );
        }
    }
}
