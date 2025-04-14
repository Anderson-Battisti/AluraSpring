package battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FipeApiController
{
    private final String apiLink   = "https://parallelum.com.br/fipe/api/v1/";
    private final String brandLink = "/marcas";
    private final String modelLink = "/modelos";
    private final String yearLink  = "/years";

    public enum QueryType { VEHICLE, BRAND, MODEL, YEAR }

    private static FipeApiController fipeApiController;

    public static FipeApiController getInstance()
    {
        if ( fipeApiController == null ) fipeApiController = new FipeApiController();

        return fipeApiController;
    }

    public HttpResponse<String> makeRequest( String veihcleType, QueryType queryType )
    {
        return makeRequest( veihcleType, null, queryType );
    }

    public HttpResponse<String> makeRequest( String veihcleType, String brandCode, QueryType queryType )
    {
        return makeRequest( veihcleType, brandCode, null, queryType );
    }

    public HttpResponse<String> makeRequest( String veihcleType, String brandCode, String year, QueryType queryType )
    {
        return fetchFipeData( veihcleType, brandCode, year, queryType );
    }

    public HttpResponse<String> fetchFipeData( String vehicleType, String brandCode, String year, QueryType queryType )
    {
        String link = composeApiLink( vehicleType, brandCode, year, queryType );

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

    public String composeApiLink( String vehicleType, String brandCode, String choosedYear, QueryType queryType )
    {
        return queryType == QueryType.VEHICLE ? apiLink + vehicleType + brandLink                                            :
               queryType == QueryType.MODEL   ? apiLink + vehicleType + brandLink + "/" + brandCode + modelLink              :
               queryType == QueryType.YEAR    ? apiLink + vehicleType + brandLink + "/" + brandCode + "/anos/" + choosedYear :
                                                null;
    }
}
