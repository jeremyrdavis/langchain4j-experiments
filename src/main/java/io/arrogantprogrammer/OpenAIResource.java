package io.arrogantprogrammer;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

@Path("/openai")
public class OpenAIResource {
    private static final Logger LOGGER = getLogger(OpenAIResource.class);
    @Inject
    ChatGPTService chatGPTService;

    @GET
    public Response writeAPoem(@QueryParam("topic") String topic) {

        POET poet = POET.randomPoet();
        LOGGER.info("Writing a poem about {} in the style of {}", topic, poet.name());
        String result = chatGPTService.writeAPoem(topic, poet.name());
        LOGGER.debug("ChatGPT says: ", result);
        return Response.ok().entity(result).build();
    }



}
