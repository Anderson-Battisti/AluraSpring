package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "orders" )
public class Order
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private LocalDate date;

    @ManyToMany( fetch = FetchType.EAGER, mappedBy = "orders" )
    private List<Product> products;

    protected Order() {}

    public Order( LocalDate date )
    {
        this.date = date;
    }

    public Long getId()
    {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }
}
