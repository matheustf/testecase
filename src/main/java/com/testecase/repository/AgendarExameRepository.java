package com.testecase.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.testecase.model.AgendaExame;


@Repository
public interface AgendarExameRepository extends MongoRepository<AgendaExame, Integer>  {
	
	
	@Query("{'dataHoraExame' : { $gte: ?0, $lte: ?1 } }")     
	List<AgendaExame> encontrarAgendaPor(LocalDateTime inicio, LocalDateTime fim); 

}
