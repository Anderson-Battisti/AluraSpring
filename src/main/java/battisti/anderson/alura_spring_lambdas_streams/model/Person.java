package battisti.anderson.alura_spring_lambdas_streams.model;

public class Person
{
    private String name;
    private int age;

    public Person( String name, int age )
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
}
