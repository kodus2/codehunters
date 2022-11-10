package hu.codehunters.serviceb.service;

import hu.codehunters.serviceb.dto.ModeratedText;
import hu.codehunters.serviceb.dto.RawText;
import hu.codehunters.serviceb.repository.ForbiddenWordsRepository;
import hu.codehunters.serviceb.repository.entity.ForbiddenWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModerationServiceTest {

	private static final String FORBIDDEN_STRING_1 = "dog";
	private static final String RAW_TEXT = "Little dog wants to eat";
	private static final String MODERATED_TEXT = "Little ***** wants to eat";

	@Mock
	private ForbiddenWordsRepository forbiddenWordsRepository;

	private final ForbiddenWord forbiddenWord1 = new ForbiddenWord();
	private final RawText rawText = new RawText(RAW_TEXT);
	private ModerationService underTest;



	@BeforeEach
	public void beforeEach() {
		forbiddenWord1.setForbiddenWord(FORBIDDEN_STRING_1);
		underTest = new ModerationService(forbiddenWordsRepository);
	}

	@Test
	void testModerateSuccess() {
		when(forbiddenWordsRepository.findByForbiddenWord(anyString())).thenReturn(Optional.empty());
		when(forbiddenWordsRepository.findByForbiddenWord(FORBIDDEN_STRING_1)).thenReturn(Optional.of(forbiddenWord1));

		ModeratedText moderateText = underTest.moderate(rawText);

		assertEquals(MODERATED_TEXT, moderateText.getModeratedText());
		verify(forbiddenWordsRepository, times(5)).findByForbiddenWord(any());

	}
}