package br.com.bhut.assessment.assessmentfelipe.controller;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import br.com.bhut.assessment.assessmentfelipe.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class LogCarsController {

    private final LogServices logCar;

    @Autowired
    public LogCarsController(LogServices logCar) {
        this.logCar = logCar;
    }

    @GetMapping("logCars")
    public List<Log> logCars() {
        return logCar.readLogs();
    }
}
