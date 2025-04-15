package battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Year
{
    @JsonProperty( "codigo" )
    private String code;

    @JsonProperty( "nome" )
    private String name;

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "[ Código: " + this.code + ", Nome: " + this.name + " ]";
    }
}
