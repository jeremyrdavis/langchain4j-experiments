package io.arrogantprogrammer;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface ChatGPTService {

    @SystemMessage("You are a professional poet")
    @UserMessage("""
                Write a poem about {topic} in the style of {poet}.
            """)
    String writeAPoem(String topic, String poet);
}
