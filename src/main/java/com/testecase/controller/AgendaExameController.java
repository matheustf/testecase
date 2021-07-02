package com.testecase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.testecase.exception.ValidacaoException;
import com.testecase.model.AgendaExame;
import com.testecase.model.ResultadoExame;
import com.testecase.repository.AgendarExameRepository;
import com.testecase.service.AgendaExameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/agendaexame")
@Api(value = "API RESTFULL AgendaExame")
public class AgendaExameController {
	
	@Autowired
	private AgendarExameRepository agendarExameRepository;
	
	@Autowired
	private AgendaExameService agendaExameService;
	
	
	
	
	
	
	@ApiOperation(value = "Salva um agendaExame")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "AgendaExame salvo.", response = ResultadoExame.class),
			@ApiResponse(code = 400, message = "Parametros inválidos ou agenda ocupada."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<AgendaExame> adicionar(@Validated @RequestBody AgendaExame resultadoExame) {

		try {
			return  ResponseEntity.status(HttpStatus.CREATED).body(agendaExameService.adicionar(resultadoExame));
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AgendaExame> atualizar(@PathVariable Long id,
			@Validated @RequestBody AgendaExame agendaExame) {

		Optional<AgendaExame> retorno = agendarExameRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		AgendaExame existente = retorno.get();
		BeanUtils.copyProperties(agendaExame, existente, "id");
		
		
		try {
			existente = agendaExameService.atualizar(existente);
		} catch (ValidacaoException e) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(existente);
	}
	
	
	
	
	
	@ApiOperation(value = "Retorna uma lista de agendaExame")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@GetMapping
	public List<AgendaExame> listar() {
		return agendarExameRepository.findAll();
	}
	
	
	@ApiOperation(value = "Retorna um único agendaExame.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@GetMapping("/{id}")
	public ResponseEntity<AgendaExame> buscar(@PathVariable Long id) {
		Optional<AgendaExame> retorno = agendarExameRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(retorno.get());
	}
	

	@ApiOperation(value = "Deleta o agendaExame")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Não foi removido."),
			@ApiResponse(code = 204, message = "Removido com sucesso."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		Optional<AgendaExame> retorno = agendarExameRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.ok().build();
		}
		agendarExameRepository.delete(retorno.get());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/teste")
	public ResponseEntity<Void> teste(String id) {
		System.out.println(id);
		return ResponseEntity.ok().build();
	}
	
}
