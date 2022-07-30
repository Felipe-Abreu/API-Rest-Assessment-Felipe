package br.com.bhut.assessment.assessmentfelipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Log {

    private String id;
    @JsonProperty("data_hora")
    private OffsetDateTime dateCar;
    @JsonProperty("car_id")
    private String carId;

}
