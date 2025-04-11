package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FipeApiController
{
    private final String apiLink = "https://parallelum.com.br/fipe/api/v1/";
    private final String brandLink = "/marcas";
    private final String modelLink = "/modelos";

    public enum QueryType { VEHICLE_TYPE, MODEL, YEAR }

    private static FipeApiController fipeApiController;

    public static FipeApiController getInstance()
    {
        if ( fipeApiController == null ) fipeApiController = new FipeApiController();

        return fipeApiController;
    }

    public HttpResponse<String> makeRequest( String veihcleType, QueryType queryType )
    {
        return makeRequest( veihcleType, queryType, null );
    }

    public HttpResponse<String> makeRequest( String veihcleType, QueryType queryType, String model )
    {
        return makeRequest( veihcleType, queryType, model, null );
    }

    public HttpResponse<String> makeRequest( String veihcleType, QueryType queryType, String model, String year )
    {
        return fetchFipeData( veihcleType, queryType, model, year );
    }

    public HttpResponse<String> fetchFipeData( String vehicleType, QueryType queryType, String model, String year )
    {
        String link = composeApiLink( vehicleType, queryType );

        try
        {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create(apiLink + vehicleType + brandLink))
                                             .build();

            return client.send( request, HttpResponse.BodyHandlers.ofString() );
        }

        catch ( Exception e )
        {
            e.printStackTrace();

            return null;
        }
    }

    public String composeApiLink( String vehicleType, QueryType queryType )
    {
        return queryType == QueryType.VEHICLE_TYPE ? apiLink + vehicleType + brandLink
                                                   : null;
    }
}
