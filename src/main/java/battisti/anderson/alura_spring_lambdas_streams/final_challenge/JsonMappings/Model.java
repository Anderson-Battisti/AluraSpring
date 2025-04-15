package battisti.anderson.alura_spring_lambdas_streams.final_challenge.JsonMappings;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties( ignoreUnknown = true )
public class Model
{
    @JsonProperty("codigo")
    String code;

    @JsonAlias( {"Modelo"} )
    @JsonProperty("nome")
    String name;

    @JsonProperty( "Valor" )
    String price;

    @JsonProperty( "AnoModelo" )
    String yearModel;

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }

    public String getYearModel()
    {
        return yearModel;
    }

    @Override
    public String toString()
    {
        return "[ Código: " + this.code + ", Nome: " + this.name + " ]";
    }
}
