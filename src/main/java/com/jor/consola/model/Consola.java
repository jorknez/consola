package com.jor.consola.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Consola {
	
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @Column(nullable = false, updatable = false)
    @Id
	private Long id;
	
	@Column(nullable = false, unique = false)
	private String fabricante;
	
	@Column(nullable = false, unique = true)
	private String modelo;
	
	@Column(nullable = false, unique = false)
	private Double precio;
	
}
