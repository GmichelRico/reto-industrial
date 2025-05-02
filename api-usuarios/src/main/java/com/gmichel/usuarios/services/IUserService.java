package com.gmichel.usuarios.services;

import java.util.List;
import java.util.Optional;

import com.gmichel.usuarios.dto.ResponseDto;
import com.gmichel.usuarios.models.entities.User;

/*
* Interfaz que define las operaciones del servicio de usuarios (CRUD)
* Separa la logica del modelo de negocio de la implementacion tecnica
* */
public interface IUserService {
	//Retorna la lista completa de usuarios
	List<User> findAll();

	//Buscamos usuario por ID
	User findById(Long id);
	
	User findByEmail(String email);
	
	User save(User newUser);
	//Actualiza un usuario recibe 2 parametros ladata y el id a actualizar
	User update(User editUser, Long id);
	
	ResponseDto deleteById(Long id);
	
}
