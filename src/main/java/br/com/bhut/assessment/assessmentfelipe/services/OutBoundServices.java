package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.model.Car;
import br.com.bhut.assessment.assessmentfelipe.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OutBoundServices implements OutBoundCalls {

    private final RestTemplate restTemplate;

    @Autowired
    public OutBoundServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Car> carsConsuming() {
        var response = restTemplate.getForEntity("http://api-test.bhut.com.br:3000/api/cars", Car[].class);
        return Optional.ofNullable(response.getBody()).map(List::of).orElse(List.of());
    }

    public Car postCar(Car car) {
        var resultCar = restTemplate.postForObject("http://api-test.bhut.com.br:3000/api/cars", car, Car.class);
        if (Objects.nonNull(resultCar)) {
            var log = new Log();
            log.setDateCar(OffsetDateTime.now());
            log.setCarId(resultCar.getId());
            //salvar log no BD
            return resultCar;
        }
        return null;
    }
}
