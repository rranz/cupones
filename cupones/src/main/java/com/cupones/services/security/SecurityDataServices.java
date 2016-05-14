package com.cupones.services.security;

import java.util.Collection;

import com.javalego.data.BusinessService;
import com.javalego.exception.LocalizedException;

import entities.Usuario;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public interface SecurityDataServices extends BusinessService {

	/**
	 * Generar un nuevo Usuario para su edición.
	 * 
	 * @return
	 */
	Usuario newInstanceUser() throws LocalizedException;

	/**
	 * Listado de Usuarios
	 * 
	 * @return
	 * @throws LocalizedException 
	 */
	Collection<Usuario> getUsers() throws LocalizedException;

	/**
	 * Obtener un Usuario por su id
	 * @param id
	 * @return
	 * @throws LocalizedException 
	 */
	Usuario getUser(long id) throws LocalizedException;
	
	/**
	 * Persistir Cliente
	 * @param user
	 * @return
	 * @throws LocalizedException
	 */
	Usuario saveUser(Usuario user) throws LocalizedException;

	/**
	 * Login
	 * @param user
	 * @return
	 * @throws LocalizedException
	 */
	Usuario login(Usuario user) throws LocalizedException;

	/**
	 * Eliminar un usuario.
	 * @param user
	 * @throws LocalizedException
	 */
	void deleteUser(Usuario user) throws LocalizedException;

	/**
	 * Buscar usuario por correo o nombre
	 * @param user
	 * @return
	 * @throws LocalizedException 
	 */
	boolean find(Usuario user) throws LocalizedException;

}
