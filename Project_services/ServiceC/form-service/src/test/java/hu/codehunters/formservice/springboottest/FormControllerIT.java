package hu.codehunters.formservice.springboottest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Path;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FormControllerIT {

    private static final String FORM = "/form";

    @Autowired
    private MockMvc mvc;

    @SneakyThrows
    @Test
    void testFormFlowSuccess() {
        mvc.perform(MockMvcRequestBuilders.post(FORM)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Files.readString(Path.of("src/test/resources/testFormFlowRequestSuccess.json")))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status()
                        .isCreated());
    }

}
