package br.com.bhut.assessment.assessmentfelipe.repository;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongodb")
public interface RepositoryDB extends MongoRepository<Log, String> {

}
