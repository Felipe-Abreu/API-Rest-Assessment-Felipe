package br.com.bhut.assessment.assessmentfelipe.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("api")
public class ConfigurationApi {

    @Value("${app.urlexternal}")
    private String bhutApi;

}
