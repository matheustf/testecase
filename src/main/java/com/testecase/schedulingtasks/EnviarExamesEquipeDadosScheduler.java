package com.testecase.schedulingtasks;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.testecase.viewer.ResultadoExameViewer;

@Component
public class EnviarExamesEquipeDadosScheduler {
	
	


	@Autowired
	private ResultadoExameViewer resultadoExameViewer;
	

	@Scheduled(cron = "0 0 8 * * *")
	public void reportCurrentTime() {
		
		resultadoExameViewer.imprimirListaResultadoExame();
	}



}
