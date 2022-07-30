package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import br.com.bhut.assessment.assessmentfelipe.repository.RepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class LogServices {

    private final RepositoryDB repositoryBD;

    @Autowired
    public LogServices(RepositoryDB repositoryBD) {
        this.repositoryBD = repositoryBD;
    }

    public List<Log> readLogs() {
        var teste = new Log();
        teste.setId("5464");
        teste.setCarId("564.6564");
        teste.setDateCar(OffsetDateTime.now());
        return List.of(teste);
    }

}
