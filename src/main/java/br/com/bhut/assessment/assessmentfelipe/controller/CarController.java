package br.com.bhut.assessment.assessmentfelipe.controller;

import br.com.bhut.assessment.assessmentfelipe.model.Car;
import br.com.bhut.assessment.assessmentfelipe.services.OutBoundCalls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api")
public class CarController {

    private final OutBoundCalls outBoundServices;

    @Autowired
    public CarController(OutBoundCalls outBoundServices) {

        this.outBoundServices = outBoundServices;
    }

    @GetMapping("listCars")
    public List<Car> listCars() {
        return outBoundServices.carsConsuming();
    }

    @PostMapping(value = "createCar", consumes = APPLICATION_JSON_VALUE)
    public Car createCar(@RequestBody Car car) {
        return outBoundServices.postCar(car);
    }

}
