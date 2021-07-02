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

import com.testecase.model.ResultadoExame;
import com.testecase.repository.ResultadoExameRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/resultadoexame")
@Api(value = "API RESTFULL ResultadoExame")
public class ResultadoExameController {

	@Autowired
	private ResultadoExameRepository userRepository;

	@ApiOperation(value = "Salva um resultadoExame")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "ResultadoExame salvo.", response = ResultadoExame.class),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ResultadoExame adicionar(@Validated @RequestBody ResultadoExame resultadoExame) {
		return userRepository.save(resultadoExame);
	}

	@ApiOperation(value = "Retorna uma lista de resultadoExame")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@GetMapping
	public List<ResultadoExame> listar() {
		return userRepository.findAll();
	}

	@ApiOperation(value = "Retorna um único resultadoExame.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@GetMapping("/{id}")
	public ResponseEntity<ResultadoExame> buscar(@PathVariable Long id) {
		Optional<ResultadoExame> retorno = userRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(retorno.get());
	}

	@ApiOperation(value = "Atualiza um resultadoExame")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Não foi Atualizado."),
			@ApiResponse(code = 200, message = "Atualizado com sucesso."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	
	@PutMapping("/{id}")
	public ResponseEntity<ResultadoExame> atualizar(@PathVariable Long id,
			@Validated @RequestBody ResultadoExame resultadoExame) {

		Optional<ResultadoExame> retorno = userRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ResultadoExame existente = retorno.get();
		BeanUtils.copyProperties(resultadoExame, existente, "id");
		existente = userRepository.save(existente);

		return ResponseEntity.ok(existente);
	}

	@ApiOperation(value = "Deleta o resultadoExame")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Não foi removido."),
			@ApiResponse(code = 204, message = "Removido com sucesso."),
			@ApiResponse(code = 500, message = "Erro interno.")

	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		Optional<ResultadoExame> retorno = userRepository.findById(id.intValue());

		if (!retorno.isPresent()) {
			return ResponseEntity.ok().build();
		}

		userRepository.delete(retorno.get());

		return ResponseEntity.ok().build();
	}

}
