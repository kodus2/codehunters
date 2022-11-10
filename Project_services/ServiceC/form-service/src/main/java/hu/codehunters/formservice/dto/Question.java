package hu.codehunters.formservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

    private CheckBox checkBox;
    private FreeText freeText;
    private RadioButton radioButton;
}
