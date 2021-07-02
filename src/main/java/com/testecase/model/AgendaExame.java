package com.testecase.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AgendaExame {
	
	
 	
    private Integer id;
    private String paciente;
    private LocalDateTime dataHoraExame ;
    private String nomeexame;
    
    
	public AgendaExame(Integer id, String paciente, LocalDateTime dataHoraExame, String nomeexame) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.dataHoraExame = dataHoraExame;
		this.nomeexame = nomeexame;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public LocalDateTime getDataHoraExame() {
		return dataHoraExame;
	}
	public void setDataHoraExame(LocalDateTime dataHoraExame) {
		this.dataHoraExame = dataHoraExame;
	}
	public String getNomeexame() {
		return nomeexame;
	}
	public void setNomeexame(String nomeexame) {
		this.nomeexame = nomeexame;
	}
    
    
    
    
	

}
