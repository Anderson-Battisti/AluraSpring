package battisti.anderson.alura_spring_lambdas_streams.controller;

import battisti.anderson.alura_spring_lambdas_streams.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskController
{
    private static TaskController instance;

    private TaskController() {};

    public static TaskController getInstance()
    {
        if ( instance == null )
        {
            instance = new TaskController();
        }

        return instance;
    }

    public void serializeTaskToJson()
    {
        Task         myTask       = new Task( "This is a test Task", "Anderson Battisti" );
        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            String taskJson = objectMapper.writeValueAsString( myTask );

            saveTaskJson( taskJson );
        }

        catch ( JsonProcessingException e )
        {
            e.printStackTrace();
        }
    }

    public void deserializeJsonToTask()
    {
        try
        {
            Task task = new ObjectMapper().readValue( new File( "C:\\Users\\ander\\Documents\\JavaProjects\\AluraSpring\\src\\assets\\tasksJson.json" ), Task.class );

            System.out.println( task );
        }

        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    private void saveTaskJson( String taskJson )
    {
        try ( FileWriter taskJsonArchive = new FileWriter( "C:\\Users\\ander\\Documents\\JavaProjects\\AluraSpring\\src\\assets\\tasksJson.json", true ) )
        {
            taskJsonArchive.write( taskJson );
        }

        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
