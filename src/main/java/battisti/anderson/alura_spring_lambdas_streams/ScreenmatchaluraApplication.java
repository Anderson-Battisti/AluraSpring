package battisti.anderson.alura_spring_lambdas_streams;

import battisti.anderson.alura_spring_lambdas_streams.controller.CountController;
import battisti.anderson.alura_spring_lambdas_streams.controller.LambdaController;
import battisti.anderson.alura_spring_lambdas_streams.controller.StreamController;
import battisti.anderson.alura_spring_lambdas_streams.controller.TaskController;
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

		//Module 1 Exercise 2, 3 and 4
		TaskController.getInstance().serializeTaskToJson();

		//Module 1 Exercise 5
		TaskController.getInstance().deserializeJsonToTask();


		//Module 2 Exercise 1
		LambdaController.getInstance().multiply();

		//Module 2 Exercise 2
		LambdaController.getInstance().checkPrimeNumber();

		//Module 2 Exercise 3
		LambdaController.getInstance().stringToUpperCase();

		//Module 2 Exercise 4
		LambdaController.getInstance().palindromeChecker();

		//Module 2 Exercise 5
		LambdaController.getInstance().multiplyArrayOfNumbers();

		//Module 2 Exercise 6
		LambdaController.getInstance().sortStrings();

		//Module 2 Exercise 7
		LambdaController.getInstance().divideNumbers();


		//Module 3 Exercise 1
		StreamController.getInstance().filterNumbers();

		//Module 3 Exercise 2
		StreamController.getInstance().stringToUpperCase();

		//Module 3 Exercise 3
		StreamController.getInstance().oddNumbersMultiplicator();

		//Module 3 Exercise 4
		StreamController.getInstance().duplicatedRemover();

		//Module 3 Exercise 5
		StreamController.getInstance().primeNumberExtractor();

		//Module 3 Exercise 6
		StreamController.getInstance().getAdults();

		//Module 3 Exercise 7 and 8
		StreamController.getInstance().filterProducts();
	}
}
