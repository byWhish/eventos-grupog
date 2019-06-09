package unq.tpi.desapp.runners;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.service.EventService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Order(4)
public class EventRunner implements CommandLineRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<EventRequest>> typeReference = new TypeReference<List<EventRequest>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/events.json");
        try {
            List<EventRequest> events = mapper.readValue(inputStream,typeReference);
            eventService.createEvents(events);
            System.out.println("Events Saved!");
        } catch (IOException e){
            System.out.println("Unable to save events: " + e.getMessage());
        }
    }
}