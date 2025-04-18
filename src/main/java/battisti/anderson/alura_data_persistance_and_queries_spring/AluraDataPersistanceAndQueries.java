package battisti.anderson.alura_data_persistance_and_queries_spring;

import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ChatGptRequestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

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
    }
}
