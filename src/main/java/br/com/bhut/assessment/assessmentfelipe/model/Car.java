package br.com.bhut.assessment.assessmentfelipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    @JsonProperty("_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private String title;
    private String brand;
    private String price;
    private Integer age;

}
