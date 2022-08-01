package br.com.bhut.assessment.assessmentfelipe.repository;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
class RepositoryDBTest {

    @Mock
    private RepositoryDB repositoryDB;

    @BeforeEach
    void loadLog() {
        repositoryDB = Mockito.mock(RepositoryDB.class);
    }

    private void listLog() {
        var logOne = new Log();
        var logTwo = new Log();
        logOne.setCarId("62e5fd35f8037d001c69e9ef");
        logOne.setDateCar(new Date(2022, 7, 31, 19, 35));
        logTwo.setDateCar(new Date(2022, 7, 30, 19, 35));
        logTwo.setCarId("59e5fd35f8037d001c59e9ef");
        Mockito.when(repositoryDB.findAll()).thenReturn(List.of(logOne, logTwo));
    }

    @Test
    void testReadLog() {
        var logs = repositoryDB.findAll();
        Assertions.assertNotNull(logs);
        Assertions.assertEquals(2, logs.size());
    }

}