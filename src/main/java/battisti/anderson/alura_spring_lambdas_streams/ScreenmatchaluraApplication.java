package battisti.anderson.alura_spring_lambdas_streams;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchaluraApplication implements CommandLineRunner
{
	public static void main( String[] args )
	{
		SpringApplication.run( ScreenmatchaluraApplication.class, args );
	}

	@Override
	public void run( String... args ) throws Exception
	{
		//Module 1 Exercise 1
		CountController.countUntilUserChoice();
	}
}
