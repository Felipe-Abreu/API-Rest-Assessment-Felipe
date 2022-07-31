package br.com.bhut.assessment.assessmentfelipe.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
public class Log {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @JsonProperty("data_hora")
    private Date dateCar;
    @JsonProperty("car_id")
    private String carId;

}
