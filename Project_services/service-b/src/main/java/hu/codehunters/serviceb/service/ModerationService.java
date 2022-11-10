package hu.codehunters.serviceb.service;

import hu.codehunters.serviceb.dto.ModeratedText;
import hu.codehunters.serviceb.dto.RawText;
import hu.codehunters.serviceb.repository.ForbiddenWordsRepository;
import hu.codehunters.serviceb.repository.entity.ForbiddenWord;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Slf4j
@Service
public class ModerationService {

	private static final String REGEX = "\\W";
	private static final String MODERATED_WORD = "*****";

	private final ForbiddenWordsRepository forbiddenWordsRepository;

	public ModeratedText moderate(RawText rawText) {
		log.trace("Moderate the requested text: {}", rawText.rawText());
		String[] rawWords = rawText.rawText().split(REGEX);
		List<ForbiddenWord> forbiddenWords = new ArrayList<>();
		Arrays.stream(rawWords)
				.forEach(rawWord -> forbiddenWordsRepository.findByForbiddenWord(rawWord)
						.ifPresent(forbiddenWords::add));
		ModeratedText moderatedText = new ModeratedText(rawText.rawText());
		forbiddenWords.forEach(forbiddenWord -> moderatedText.setModeratedText(moderatedText.getModeratedText()
				.replaceAll(forbiddenWord.getForbiddenWord(), MODERATED_WORD)));
		return moderatedText;
	}
}
