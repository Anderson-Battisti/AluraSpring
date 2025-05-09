package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

@Entity
public class Product
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( unique = true, nullable = false )
    private String name;

    @Column( name = "value" )
    private double price;

    protected Product() {}

    public Product( String name, double price )
    {
        this.name  = name;
        this.price = price;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }
}
