package br.com.bhut.assessment.assessmentfelipe.services;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import br.com.bhut.assessment.assessmentfelipe.repository.RepositoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServices {

    @Autowired
    private RepositoryDB repositoryDB;

    public List<Log> readLogs() {
        List<Log> log = repositoryDB.findAll();
        return log;
    }

}
