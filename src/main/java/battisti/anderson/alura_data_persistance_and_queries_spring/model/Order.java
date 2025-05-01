package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table( name = "orders" )
public class Order
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private LocalDate date;

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
