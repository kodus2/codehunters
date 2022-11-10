package hu.codehunters.serviceb.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ModerationControllerTest {

	private static final String FORBIDDEN_WORDS = "/home/forbiddenWords";
	private static final String TEST_FORBIDDEN_WORD = """
			{
				"forbiddenWord": "%s"
			}
			""";
	private static final String MODERATION = "/moderation";
	private static final String TEST_RAW_TEXT = """
			{
				"rawText": "%s"
			}
			""";

	@Autowired
	private MockMvc mvc;

	@SneakyThrows
	@Test
	void testModerateSuccess() {
		// Given
		mvc.perform(MockMvcRequestBuilders.post(FORBIDDEN_WORDS)
						.contentType(MediaType.APPLICATION_JSON)
						.content(String.format(TEST_FORBIDDEN_WORD, "dog"))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());

		//When - Then
		mvc.perform(MockMvcRequestBuilders.post(MODERATION)
						.contentType(MediaType.APPLICATION_JSON)
						.content(String.format(TEST_RAW_TEXT, "Little dog wants to eat."))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("moderatedText").hasJsonPath())
				.andExpect(MockMvcResultMatchers.jsonPath("moderatedText")
						.value("Little ***** wants to eat."));

	}
}