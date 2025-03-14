package battisti.anderson.alura_spring_lambdas_streams.model;

public class Task
{
    private String description;
    private boolean done;
    private String responsiblePerson;

    public Task() {};

    public Task( String description, String responsiblePerson )
    {
        this.description = description;
        this.responsiblePerson = responsiblePerson;
        this.done = false;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isDone()
    {
        return done;
    }

    public void setDone(boolean done)
    {
        this.done = done;
    }

    public String getResponbiblePerson()
    {
        return responsiblePerson;
    }

    public void setResponbiblePerson(String responbiblePerson)
    {
        this.responsiblePerson = responbiblePerson;
    }

    @Override
    public String toString()
    {
        return "Task description: " + description + ", done: " + done + ", responsiblePerson: " + responsiblePerson;
    }
}
