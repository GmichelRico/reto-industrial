package com.gmichel.usuarios.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Entidad JPÄ para representar a un usuario en el sistema.
* Mapea la tabla de usuarios en la base de datos.
* */
@Entity
@Table(name = "USERS")
//Genera los getters, setters, gracias a libreria lombok
@Data
// Permite construir objetos con patron builder (lombok)
@Builder
// Constructor con todos los campos
@AllArgsConstructor
// Constructor sin argumentos
@NoArgsConstructor
public class User {
	
	/*Identificador unico con un ID autoincrementable generado por una sequencia*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Long id;
		
	@NotBlank
	@Column(name = "FULL_NAME")
	private String fullName; 
	
	@NotBlank
	@Column(name = "USERNAME")
	private String username;
	
	@NotBlank
	@Column(name = "PASSWORD")
	private String password;
	
	
	/* Campo de email con valor unico y con anotacion de tipo email para que sea valido*/
	@Email
	@NotBlank
	// El Correco debe ser unico y valido
	@Column(name = "EMAIL", nullable = false, unique = true)
	@Size(max = 100)
	private String email;
	
	@Column(name = "USER_CREATION_DATE")
	private LocalDate user_creationDate;

	/*
		Callback para ejecutar antes de insertar un registro
		con la fecha actual (solo para saber cuando se creo)
	*/
	@PrePersist
	protected void onCreate() {
		this.user_creationDate = LocalDate.now();
	}
}
