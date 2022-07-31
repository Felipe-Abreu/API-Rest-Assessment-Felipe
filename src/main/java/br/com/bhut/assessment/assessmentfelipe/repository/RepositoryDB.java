package br.com.bhut.assessment.assessmentfelipe.repository;

import br.com.bhut.assessment.assessmentfelipe.model.Log;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository("mongodb")
public interface RepositoryDB extends MongoRepository<Log, String> {

}
