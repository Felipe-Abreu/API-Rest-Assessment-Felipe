package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.config.ConfigurationApi;
import br.com.bhut.assessment.assessmentfelipe.model.Car;
import br.com.bhut.assessment.assessmentfelipe.model.Log;
import br.com.bhut.assessment.assessmentfelipe.repository.RepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OutBoundServices implements OutBoundCalls {

    private final RestTemplate restTemplate;
    private final RepositoryDB repositoryDB;
    private final ConfigurationApi configurationApi;

    @Autowired
    public OutBoundServices(RestTemplate restTemplate, RepositoryDB repositoryDB, ConfigurationApi configurationApi) {

        this.restTemplate = restTemplate;
        this.repositoryDB = repositoryDB;
        this.configurationApi = configurationApi;
    }

    public List<Car> carsConsuming() {
        var response = restTemplate.getForEntity(configurationApi.getBhutApi(), Car[].class);
        return Optional.ofNullable(response.getBody()).map(List::of).orElse(List.of());
    }

    public Car postCar(Car car) {
        var resultCar = restTemplate.postForObject(configurationApi.getBhutApi(), car, Car.class);
        if (Objects.nonNull(resultCar)) {
            var log = new Log();
            log.setDateCar(Date.from(OffsetDateTime.now().toInstant()));
            log.setCarId(resultCar.getId());
            repositoryDB.save(log);
            return resultCar;
        }
        return null;
    }
}
