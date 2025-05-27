package battisti.anderson.alura_data_persistance_and_queries_spring;

import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ChatGptRequestController;
import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ModuleFourExercises;
import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ModuleOneExercises;
import battisti.anderson.alura_data_persistance_and_queries_spring.controller.ModuleTwoExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraDataPersistanceAndQueries
    implements
        CommandLineRunner
{
    @Autowired
    private ModuleTwoExercises moduleTwoExercises;

    @Autowired
    private ModuleFourExercises moduleFourExercises;

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

        //Module 2 Exercise 8
        moduleTwoExercises.createAndSaveEachObjectInDatabase();

        //Module 4
        moduleFourExercises.createAndSaveCategory();

        //Module 4 Exercise 1
        moduleFourExercises.showProductsByName();

        //Module 4 Exercise 2
        moduleFourExercises.showProductsByCategory();

        //Module 4 Exercise 3
        moduleFourExercises.showProductsByPriceGreaterThanValue();

        //Module 4 Exercise 4
        moduleFourExercises.showProductsByPriceLessThanValue();

        //Module 4 Exercise 5
        moduleFourExercises.showProductsByNameContaining();

        //Module 4 Exercise 8
        moduleFourExercises.showProductByCategoryOrdeningByAscPrice();

        //Module 4 Exercise 9
        moduleFourExercises.showProductByCategoryOrdeningByPriceDesc();

        //Module 4 Exercise 10
        moduleFourExercises.showProductCountByCategory();

        //Module 4 Exercise 11
        moduleFourExercises.showProductCountByPriceGreaterThan();
    }
}
