package unq.tpi.desapp.webservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.service.Ping;

@RestController
public class PingService {

    @GetMapping(value="/ping")
    public Ping ping() {
        return new Ping();
    }
}
