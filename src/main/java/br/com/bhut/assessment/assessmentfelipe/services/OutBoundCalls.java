package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.model.Car;

import java.util.List;

public interface OutBoundCalls {

    List<Car> carsConsuming();

    Car postCar(Car car);
}
