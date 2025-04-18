package battisti.anderson.alura_data_persistance_and_queries_spring.controller;

import battisti.anderson.alura_data_persistance_and_queries_spring.service.ChatGptApiConsumer;

import java.util.Scanner;

public class ChatGptRequestController
{
    private static ChatGptRequestController instance;

    private ChatGptRequestController() {}

    public static ChatGptRequestController getInstance()
    {
        if ( instance == null )
        {
            return new ChatGptRequestController();
        }

        return instance;
    }

    public void translateTextByAI()
    {
        Scanner reader = new Scanner( System.in );

        System.out.println( "Write a text to be translated to portuguese by AI: " );
        String text = reader.nextLine();

        String tralnslatedText = ChatGptApiConsumer.getTradution( text );

        System.out.println( "Translated text: " + tralnslatedText );
    }
}
