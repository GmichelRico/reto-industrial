package com.gmichel.usuarios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gmichel.usuarios.models.entities.User;

/*
* Repositorio de acceso a datos para la entidad User
* extiende de JpaRepository para utilizar los Metodos de CRUD
* */
public interface UserRepository extends JpaRepository<User, Long> {
    /*
	Busca el usuario por username
	Optional<UserEntities> findByUsername(String username);
    */

    /*Busca un usuario por su correo electronico
    * por @param  y @return Optional que contiene  el usuario
    * esto es un consulta automatica
    * */
    Optional<User> findByEmail(String email);

}
