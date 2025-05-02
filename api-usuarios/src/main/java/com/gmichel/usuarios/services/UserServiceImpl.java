package com.gmichel.usuarios.services;

import com.gmichel.usuarios.dto.ResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmichel.usuarios.models.entities.User;
import com.gmichel.usuarios.repositories.UserRepository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


/*Implementacion de la logica y se coloca la anotacion de que es un servicio*/
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	// Lista para todos los usuarios
	@Override
	// Optimizamos rendimiento por ser solo lectura
	@Transactional(readOnly = true)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public User findById(Long id){
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);

	}

	@Override
	// Inicia una transaccion en caso de no cumplirse hace un rollback
	// Garantiza una operacion ACID
	@Transactional
	public User findByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }
	
	/*
	@Override
	@Transactional(readOnly = true)
	public Optional<UserEntities> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	*/
	
	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public User update(User user, Long id) {
		// Busca el usuario por id
		Optional<User> opt = userRepository.findById(id);

		//Construimos nuestro usuario con lmbok
		if(opt.isPresent()) {
			return userRepository.save(User
					.builder()
					.id(id)
					.fullName(user.getFullName())
					.username(user.getUsername())
					.password(user.getPassword())
					.email(user.getEmail())
					.build());
		}
		return null;
	}

	@Override
	public ResponseDto deleteById(Long id) {
		userRepository.deleteById(id);

		if (userRepository.findById(id).isEmpty()) {
			return new ResponseDto(String.format("User with id %d, deleted successfully", id));
		}

		return new ResponseDto(String.format("Error while deleting user with id: %d", id));
	}


}
