package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Brand;
import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.FipeResponse;
import battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings.Model;
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

        FipeResponse models = getFipeResponseObject( FipeApiController.getInstance()
                                                                      .makeRequest( vehicleType, brandCode, FipeApiController.QueryType.MODEL )
                                                                      .body() );

        if ( models == null )
        {
            return;
        }

        printsEachItem( models );

        String modelCode = requireVehicleCode( models );

        List<Model> modelsOfEachYear = getListOfModels( FipeApiController.getInstance()
                                                                         .makeRequest( vehicleType, brandCode, modelCode, FipeApiController.QueryType.YEAR )
                                                                         .body() );

        if ( modelsOfEachYear == null )
        {
            return;
        }

        printInfoOfEachVehicle( vehicleType, brandCode, modelCode, FipeApiController.QueryType.FINAL, modelsOfEachYear );
    }

    public String requireVehicleType()
    {
        Scanner reader = new Scanner( System.in );

        String vehicleChoice = null;

        System.out.println( "\nDigite uma das opções para consultar valores: " );
        System.out.println( "Opções: Carros, Motos, Caminhoes" );

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

    private String requireVehicleCode( FipeResponse models )
    {
        Scanner reader = new Scanner( System.in );

        final String[] code = new String[1];

        System.out.println( "Escolha o código do veículo que deseja visualizar: " );
        code[0] = reader.nextLine();

        while ( models.getModels().stream().noneMatch( b -> b.getCode().equals( code[0] ) ) )
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

            return mapper.readValue( json, new TypeReference<>() {} );
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

            return mapper.readValue( json, new TypeReference<>() {} );
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();

            return null;
        }
    }

    private Model getModelByJson( String json )
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue( json, new TypeReference<>() {} );
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();

            return null;
        }
    }

    private FipeResponse getFipeResponseObject( String json )
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue( json, new TypeReference<>() {} );
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

    public void printsEachItem( FipeResponse models )
    {
        System.out.println( "Modelos: " );

        models.getModels().forEach( System.out::println );
    }

    public void printInfoOfEachVehicle( String vehicleType, String brandCode, String modelCode, FipeApiController.QueryType queryType, List<Model> models )
    {
        models.stream()
              .map( m -> m.getCode() )
              .map( c -> FipeApiController.getInstance()
                                          .makeRequest( vehicleType, brandCode, modelCode, c, queryType )
                                          .body() )
              .map( this::getModelByJson ).forEach( m -> System.out.println( "\n Modelo: " + m.getName()      +
                                                                             "\n Ano: "    + m.getYearModel() +
                                                                             "\n Preço: "  + m.getPrice() ) );

    }
}
