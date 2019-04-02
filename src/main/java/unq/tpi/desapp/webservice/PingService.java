package unq.tpi.desapp.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.service.Ping;

@RestController
public class PingService {

    @RequestMapping("/ping")
    public Ping ping() {
        return new Ping();
    }
}
