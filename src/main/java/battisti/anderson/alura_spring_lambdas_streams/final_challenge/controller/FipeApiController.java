package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FipeApiController
{
    private final String apiLink = "https://parallelum.com.br/fipe/api/v2/";
    //private final String apiLink = "https://parallelum.com.br/fipe/api/v2/cars/fipe/001005-1";

    private static FipeApiController fipeApiController;

    public static FipeApiController getInstance()
    {
        if ( fipeApiController == null ) fipeApiController = new FipeApiController();

        return fipeApiController;
    }

    public void makeRequest( String veihcleType )
    {
        
    }

    public HttpResponse<String> fetchFipeData( String vehicleType )
    {
        try
        {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri( URI.create( apiLink + vehicleType ) )
                                             .build();

            return client.send( request, HttpResponse.BodyHandlers.ofString() );
        }

        catch ( Exception e )
        {
            e.printStackTrace();

            return null;
        }
    }
}
