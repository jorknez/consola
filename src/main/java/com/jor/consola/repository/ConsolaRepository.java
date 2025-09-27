package com.jor.consola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jor.consola.model.Consola;

@Repository
public interface ConsolaRepository extends JpaRepository<Consola, Long> 
{

}
