package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FipeApiController
{
    public enum QueryType { VEHICLE, MODEL, YEAR, FINAL }

    private static FipeApiController fipeApiController;

    public static FipeApiController getInstance()
    {
        if ( fipeApiController == null ) fipeApiController = new FipeApiController();

        return fipeApiController;
    }

    public HttpResponse<String> makeRequest( String vehicleType, QueryType queryType )
    {
        return makeRequest( vehicleType, null, queryType );
    }

    public HttpResponse<String> makeRequest( String vehicleType, String brandCode, QueryType queryType )
    {
        return makeRequest( vehicleType, brandCode, null, queryType );
    }

    public HttpResponse<String> makeRequest( String vehicleType, String brandCode, String modelCode, QueryType queryType )
    {
        return makeRequest( vehicleType, brandCode, modelCode, null, queryType );
    }

    public HttpResponse<String> makeRequest( String vehicleType, String brandCode, String modelCode, String finalCode, QueryType queryType )
    {
        return fetchFipeData( vehicleType, brandCode, modelCode, finalCode, queryType );
    }

    public HttpResponse<String> fetchFipeData( String vehicleType, String brandCode, String modelCode, String finalCode, QueryType queryType )
    {
        String link = composeApiLink( vehicleType, brandCode, modelCode, finalCode, queryType );

        try
        {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri( URI.create( link ) )
                                             .build();

            return client.send( request, HttpResponse.BodyHandlers.ofString() );
        }

        catch ( Exception e )
        {
            e.printStackTrace();

            return null;
        }
    }

    public String composeApiLink( String vehicleType, String brandCode, String modelCode, String finalCode, QueryType queryType )
    {
        final String apiLink   = "https://parallelum.com.br/fipe/api/v1/";
        final String brandLink = "/marcas";
        final String modelLink = "/modelos";
        final String yearLink  = "/anos";

        return queryType == QueryType.VEHICLE ? apiLink + vehicleType + brandLink                                                                              :
               queryType == QueryType.MODEL   ? apiLink + vehicleType + brandLink + "/" + brandCode + modelLink                                                :
               queryType == QueryType.YEAR    ? apiLink + vehicleType + brandLink + "/" + brandCode + modelLink + "/" + modelCode + yearLink                   :
               queryType == QueryType.FINAL   ? apiLink + vehicleType + brandLink + "/" + brandCode + modelLink + "/" + modelCode + yearLink + "/" + finalCode :
                                                null;
    }
}
