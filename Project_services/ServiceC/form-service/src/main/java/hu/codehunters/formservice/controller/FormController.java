package hu.codehunters.formservice.controller;

import hu.codehunters.formservice.dto.RequestFormDto;
import hu.codehunters.formservice.dto.ResponseFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.codehunters.formservice.service.FormService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/")
public class FormController {

    private final FormService formService;

    @PostMapping(path = "/form")
    public ResponseEntity<ResponseFormDto> storeForm(@RequestBody RequestFormDto request) {
        ResponseFormDto response = formService.storeForm(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
