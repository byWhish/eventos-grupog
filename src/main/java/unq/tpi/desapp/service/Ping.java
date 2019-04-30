package unq.tpi.desapp.service;

import org.springframework.stereotype.Service;

@Service
public class Ping {

    private final String message;

    public Ping() {
        this.message = "pong";
    }

public String getMessage() {
    return this.message;
};

};
