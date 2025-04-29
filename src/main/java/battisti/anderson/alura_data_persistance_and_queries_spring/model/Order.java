package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Order
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false )
    private LocalDate date;

    public Long getId()
    {
        return id;
    }

    public LocalDate getDate()
    {
        return date;
    }
}
