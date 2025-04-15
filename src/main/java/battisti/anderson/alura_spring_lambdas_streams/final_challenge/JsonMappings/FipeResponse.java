package battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FipeResponse
{
    @JsonProperty( "modelos" )
    private List<Model> models;

    @JsonProperty( "anos" )
    private List<Year> years;

    public List<Model> getModels()
    {
        return models;
    }

    public List<Year> getYears()
    {
        return years;
    }
}
