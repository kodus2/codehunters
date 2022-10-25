package hu.codehunters.simpleapplication.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class HelloRestController {

    @GetMapping(path = "/hello")
    public String welcome() {
        return "Welcome on my site";
    }
}
