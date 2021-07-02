package com.testecase.viewer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testecase.model.ResultadoExame;
import com.testecase.repository.ResultadoExameRepository;

@Component
public class ResultadoExameViewer {

	private static final Logger log = LoggerFactory.getLogger(ResultadoExameViewer.class);

	@Autowired
	private ResultadoExameRepository userRepository;

	public void imprimirListaResultadoExame() {
		ObjectMapper Obj = new ObjectMapper();

		userRepository.findAll().stream().forEach(e -> {
			try {
				log.info(Obj.writeValueAsString(e));
			} catch (JsonProcessingException e1) {
				log.error(e1.getMessage());
			}
		});

	}

}
