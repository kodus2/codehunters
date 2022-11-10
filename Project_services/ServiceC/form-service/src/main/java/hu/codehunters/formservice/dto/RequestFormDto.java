package hu.codehunters.formservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestFormDto {

    private String id;
    private String name;
    private String description;
    private Boolean active;
    private List<Question> questions;

}
