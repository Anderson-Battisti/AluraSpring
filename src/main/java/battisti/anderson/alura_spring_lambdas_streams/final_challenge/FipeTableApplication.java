package battisti.anderson.alura_spring_lambdas_streams.final_challenge;

import battisti.anderson.alura_spring_lambdas_streams.final_challenge.controller.MenuController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableApplication
        implements
            CommandLineRunner
{
    public static void main( String[] args )
    {
        SpringApplication.run( FipeTableApplication.class, args );
    }

    @Override
    public void run( String... args )
    {
        MenuController.getInstance().runMenu();
    }
}
