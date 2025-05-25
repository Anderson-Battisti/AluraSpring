package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

import java.util.List;

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

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "category_id" )
    private Category category;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name               = "order_product",
                joinColumns        = @JoinColumn( name = "product_id" ),
                inverseJoinColumns = @JoinColumn( name = "order_id" ) )
    private List<Order> orders;

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

    @Override
    public String toString()
    {
        return this.name;
    }
}
