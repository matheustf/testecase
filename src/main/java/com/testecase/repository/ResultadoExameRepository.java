package com.testecase.repository;

import com.testecase.model.ResultadoExame;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  ResultadoExameRepository extends MongoRepository<ResultadoExame, Integer>  {

}
