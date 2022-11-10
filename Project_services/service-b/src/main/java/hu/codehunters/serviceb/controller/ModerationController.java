package hu.codehunters.serviceb.controller;

import hu.codehunters.serviceb.dto.ModeratedText;
import hu.codehunters.serviceb.dto.RawText;
import hu.codehunters.serviceb.service.ModerationService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
public class ModerationController {

	private final ModerationService moderationService;

	@PostMapping("/moderation")
	public ResponseEntity<ModeratedText> moderate(@RequestBody RawText text) {
		return ResponseEntity.ok(moderationService.moderate(text));
	}
}
