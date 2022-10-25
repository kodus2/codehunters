package hu.codehunters.gradlespringtask.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping(path = "/")
    public String getHomePage() {
        return "This is the home page.";
    }
}
