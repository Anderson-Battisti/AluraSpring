package battisti.anderson.alura_data_persistance_and_queries_spring.model;

import jakarta.persistence.*;

@Entity
public class Category
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( nullable = false, unique = true )
    private String name;

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
