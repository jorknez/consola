package com.jor.consola.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jor.consola.exceptions.NoSuchConsolaException;
import com.jor.consola.model.Consola;
import com.jor.consola.repository.ConsolaRepository;
import com.jor.consola.service.IConsolaService;

public class ConsolaServiceImpl implements IConsolaService {

	@Autowired
	private ConsolaRepository consolaRepository;
	
	@Override
	public Consola addConsola(Consola consola) {
		return consolaRepository.save(consola);
	}

	@Override
	public List<Consola> findAllConsola() {
		return consolaRepository.findAll();
	}

	@Override
	public Consola findConsolaByID(long id) {
		Optional<Consola> consola = consolaRepository.findById(id);
		if (consola.isPresent()) {
			return consola.get();
		} else {
			throw new NoSuchConsolaException("No hay consola con el id: " + id);
		}
	}

	@Override
	public void deleteAllData() {
		consolaRepository.deleteAll();
	}

	@Override
	public void deleteConsolaByID(long id) {
		consolaRepository.deleteById(id);

	}

}
