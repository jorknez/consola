package com.jor.consola.service;

import java.util.List;

import com.jor.consola.model.Consola;

public interface IConsolaService {

	Consola addConsola(Consola consola);

	List<Consola> findAllConsola();

	Consola findConsolaByID(long id);

	void deleteAllData();

	void deleteConsolaByID(long id);

}
