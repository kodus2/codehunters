package hu.codehunters.formservice.service;

import hu.codehunters.formservice.dto.RequestFormDto;
import hu.codehunters.formservice.dto.ResponseFormDto;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    public ResponseFormDto storeForm(RequestFormDto request) {
        return new ResponseFormDto("Just a text");
    }
}
