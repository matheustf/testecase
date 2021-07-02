package com.testecase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testecase.exception.ValidacaoException;
import com.testecase.model.AgendaExame;
import com.testecase.repository.AgendarExameRepository;
import com.testecase.util.DateUtil;

@Service
public class AgendaExameService {

	@Autowired
	private AgendarExameRepository agendarExameRepository;
	@Autowired
	private DateUtil dateUtil;

	public AgendaExame adicionar(AgendaExame agendaExame) throws ValidacaoException {

		agendaExame.setDataHoraExame(dateUtil.zerarMinSecNan(agendaExame.getDataHoraExame()));
		LocalDateTime dataFim = agendaExame.getDataHoraExame().plusHours(1);
		List<AgendaExame> examesMarcados = agendarExameRepository.encontrarAgendaPor(agendaExame.getDataHoraExame(),
				dataFim);

		if (examesMarcados != null && !examesMarcados.isEmpty()) {
			throw new ValidacaoException("Agenda ocupada.");
		}

		return agendarExameRepository.save(agendaExame);

	}

	public AgendaExame atualizar(AgendaExame agendaExame) throws ValidacaoException {
		agendaExame.setDataHoraExame(dateUtil.zerarMinSecNan(agendaExame.getDataHoraExame()));
		LocalDateTime dataFim = agendaExame.getDataHoraExame().plusHours(1);
		List<AgendaExame> examesMarcados = agendarExameRepository.encontrarAgendaPor(agendaExame.getDataHoraExame(),
				dataFim);

		if (examesMarcados != null) {
			examesMarcados.removeIf(e -> e.getId() == agendaExame.getId());
			if (!examesMarcados.isEmpty()) {
				throw new ValidacaoException("Agenda ocupada.");
			}
		}

		return agendarExameRepository.save(agendaExame);

	}

}
