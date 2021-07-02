package com.testecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.testecase.controller.AgendaExameController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberITExemplo {

	@Autowired
	AgendaExameController agendaExameController;

	@Given("que criei um metodo")
	public void queCrieiUmMetodo() {
		agendaExameController.teste("word");
		System.out.println(1);
	}

	@When("executá-lo")
	public void executáLo() {
		System.out.println(2);
	}

	@Then("o resultado deve ser sucesso")
	public void oResultadoDeveSerSucesso() {
		System.out.println(3);
	}

}
