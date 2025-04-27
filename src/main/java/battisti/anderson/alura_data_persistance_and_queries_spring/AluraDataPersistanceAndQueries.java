package battisti.anderson.alura_data_persistance_and_queries_spring;

import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ChatGptRequestController;
import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ModuleOneExercises;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraDataPersistanceAndQueries
    implements
        CommandLineRunner
{
    public static void main( String[] args )
    {
        SpringApplication.run( AluraDataPersistanceAndQueries.class, args );
    }

    @Override
    public void run( String... args ) throws Exception
    {
        ChatGptRequestController.getInstance().translateTextByAI();

        //Module 1 Exercise 1
        ModuleOneExercises.getInstance().convertStringToNumber();

        //Module 1 Exercise 3
        ModuleOneExercises.getInstance().printFirstAndLastName();
    }
}
