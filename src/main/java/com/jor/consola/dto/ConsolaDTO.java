package com.jor.consola.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ConsolaDTO {

	@NotBlank(message = "El fabricante es requerido")
    @Size(min = 2, max = 50, message = "fabricante must be between 2 y 50 letras")
	private String fabricante;
	
	@NotBlank(message = "El modelo es requerido")
    @Size(min = 2, max = 50, message = "El modelo debe tener entre 2 y 50 letras")
	private String modelo;
	
	@NotBlank(message = "precio is required")
	@Min(0)
	private Double precio;
}
