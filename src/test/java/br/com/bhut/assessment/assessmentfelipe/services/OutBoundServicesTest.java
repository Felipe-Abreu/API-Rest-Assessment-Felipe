package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.config.ConfigurationApi;
import br.com.bhut.assessment.assessmentfelipe.model.Car;
import br.com.bhut.assessment.assessmentfelipe.model.Log;
import br.com.bhut.assessment.assessmentfelipe.repository.RepositoryDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
class OutBoundServicesTest {

    @Mock
    OutBoundCalls outBoundCalls;
    @Mock
    RestTemplate restTemplate;
    @Mock
    RepositoryDB repositoryDB;
    Car carWithoutID;
    Car carWithID;
    OutBoundServices outBoundServices;
    Log logWithID;
    @Mock
    ConfigurationApi configurationApi;

    @BeforeEach
    void load() {
        outBoundCalls = Mockito.mock(OutBoundCalls.class);
        restTemplate = Mockito.mock(RestTemplate.class);
        repositoryDB = Mockito.mock(RepositoryDB.class);
        configurationApi = Mockito.mock(ConfigurationApi.class);
        Mockito.when(configurationApi.getBhutApi()).thenReturn("");
        outBoundServices = new OutBoundServices(restTemplate, repositoryDB, configurationApi);
    }

    @Test
    void testLog() {
        initializeCar();
        Mockito.when(restTemplate.postForObject(configurationApi.getBhutApi(), carWithoutID, Car.class)).thenReturn(carWithID);
        initializeLog();
        outBoundServices.postCar(carWithoutID);
        Mockito.when(repositoryDB.save(Mockito.any(Log.class))).thenReturn(logWithID);
        verify(repositoryDB, times(1)).save(Mockito.any(Log.class));
    }

    private void initializeCar() {
        carWithID = new Car();
        carWithoutID = new Car();
        carWithoutID.setAge(2001);
        carWithoutID.setBrand("VW");
        carWithoutID.setPrice("50");
        carWithoutID.setTitle("Fusca");
        carWithID.setAge(2001);
        carWithID.setId("2");
        carWithID.setBrand("VW");
        carWithID.setPrice("50");
        carWithID.setTitle("Fusca");
    }

    private void mockCarId() {
        initializeCar();
        Mockito.when(outBoundCalls.postCar(carWithoutID)).thenReturn(carWithID);
    }

    private void initializeLog() {
        logWithID = new Log();
        logWithID.setId("23");
        logWithID.setCarId("2");
        logWithID.setDateCar(Date.from(OffsetDateTime.now().toInstant()));
    }

    private void mockListEmpty() {

        Mockito.when(outBoundCalls.carsConsuming()).thenReturn(List.of());
    }

    private void mockListTwoCars() {
        var carTwo = new Car();
        var carOne = new Car();
        carOne.setAge(2001);
        carOne.setId("1");
        carOne.setBrand("VW");
        carOne.setPrice("50");
        carOne.setTitle("Fusca");
        carTwo.setAge(2020);
        carTwo.setId("2");
        carTwo.setBrand("Ford");
        carTwo.setPrice("5000");
        carTwo.setTitle("Ka");
        Mockito.when(outBoundCalls.carsConsuming()).thenReturn(List.of(carOne, carTwo));
    }

    @Test
    void testIfListIsEmpty() {
        mockListEmpty();
        Assertions.assertTrue(outBoundCalls.carsConsuming().isEmpty());
    }

    @Test
    void testIfListTwoCars() {
        mockListTwoCars();
        var cars = outBoundCalls.carsConsuming();
        var carFord = cars.stream().filter(car -> car.getBrand().equals("Ford")).findFirst().orElse(null);
        var carVW = cars.stream().filter(car -> car.getBrand().equals("VW")).findFirst().orElse(null);
        Assertions.assertNotNull(carFord);
        Assertions.assertNotNull(carVW);
        Assertions.assertEquals("Ka", carFord.getTitle());
        Assertions.assertEquals("Fusca", carVW.getTitle());
        Assertions.assertEquals(2, cars.size());
    }

    @Test
    void testCreateCar() {
        var car = outBoundCalls.postCar(carWithoutID);
        Assertions.assertEquals(carWithID, car);
    }
}