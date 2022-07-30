package br.com.bhut.assessment.assessmentfelipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/**
 * ToDo testes unitários
 * ToDo salvar log no BD
 * ToDo parametrizar a URL da api externa - obrigatorios
 * ToDo criar fila - opcional
 * ToDo consumir a fila - opcional
 */
public class AssessmentFelipeApplication {

    public static void main(String[] args) {

        SpringApplication.run(AssessmentFelipeApplication.class, args);

    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
