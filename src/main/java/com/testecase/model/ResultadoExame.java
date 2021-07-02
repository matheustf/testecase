package com.testecase.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ResultadoExame {
	
	
	 	@Id
	    private Integer id;
	    private String nome;
	    private String descricao;
	    private Laboratorio laboratorio;
	    private Cliente cliente;
	    private String medico;
	    private String crm;
	    private String resultado;
	    private LocalDate dataExame;
	    private LocalDate dataResultado;
	    
	    
	
	
	
		
		public ResultadoExame(Integer id, String nome, String descricao, Laboratorio laboratorio, Cliente cliente,
				String medico, String crm, String resultado, LocalDate dataExame, LocalDate dataResultado) {
			super();
			this.id = id;
			this.nome = nome;
			this.descricao = descricao;
			this.laboratorio = laboratorio;
			this.cliente = cliente;
			this.medico = medico;
			this.crm = crm;
			this.resultado = resultado;
			this.dataExame = dataExame;
			this.dataResultado = dataResultado;
		}
		
		public void setDataResultado(LocalDate dataResultado) {
			this.dataResultado = dataResultado;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
	
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Laboratorio getLaboratorio() {
			return laboratorio;
		}

		public void setLaboratorio(Laboratorio laboratorio) {
			this.laboratorio = laboratorio;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public String getMedico() {
			return medico;
		}

		public void setMedico(String medico) {
			this.medico = medico;
		}

		public String getCrm() {
			return crm;
		}

		public void setCrm(String crm) {
			this.crm = crm;
		}

		public String getResultado() {
			return resultado;
		}

		public void setResultado(String resultado) {
			this.resultado = resultado;
		}

		public LocalDate getDataExame() {
			return dataExame;
		}

		public void setDataExame(LocalDate dataExame) {
			this.dataExame = dataExame;
		}
		public LocalDate getDataResultado() {
			return dataResultado;
		}

	
		
	    
	    

}
