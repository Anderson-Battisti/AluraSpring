package battisti.anderson.alura_data_persistance_and_queries_spring.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.util.List;

public class ChatGptApiConsumer
{
    @Value("${alura.spring.apy_key}")
    private static String apiKey;

    public static String getTradution( String text )
    {
        OpenAiService service = new OpenAiService( apiKey );

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                                                             .model( "gpt-3.5-turbo" )
                                                             .messages( List.of( new ChatMessage( "user", "Translate to portuguese this text (Only the transaltion, without any other comment): " + text ) ) )
                                                             .maxTokens( 1000 )
                                                             .temperature( 0.7 )
                                                             .build();


        ChatCompletionResult result = service.createChatCompletion( request );

        return result.getChoices().get( 0 ).getMessage().getContent();
    }
}
