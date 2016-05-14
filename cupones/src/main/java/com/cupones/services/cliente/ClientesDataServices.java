package com.cupones.services.cliente;

import java.util.Collection;

import com.javalego.data.BusinessService;
import com.javalego.exception.LocalizedException;

import entities.Cliente;
import entities.ClienteCupon;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public interface ClientesDataServices extends BusinessService {

	/**
	 * Generar un nuevo Cliente para su edición.
	 * 
	 * @return
	 */
	Cliente newInstanceCliente() throws LocalizedException;

	/**
	 * Listado de Clientes
	 * 
	 * @return
	 * @throws LocalizedException 
	 */
	Collection<Cliente> getClientes() throws LocalizedException;

	/**
	 * Obtener un Cliente por su id
	 * @param id
	 * @return
	 * @throws LocalizedException 
	 */
	Cliente getCliente(long id) throws LocalizedException;
	
	/**
	 * Obtener el cupón de un Cliente por su id
	 * @param id
	 * @return
	 * @throws LocalizedException 
	 */
	ClienteCupon getClienteCupon(long id) throws LocalizedException;
	
	/**
	 * Persistir Cliente
	 * @param cliente
	 * @return
	 * @throws LocalizedException
	 */
	Cliente saveCliente(Cliente cliente) throws LocalizedException;

	/**
	 * Eliminar un cupón.
	 * @param cliente
	 * @throws LocalizedException
	 */
	void deleteCliente(Cliente cliente) throws LocalizedException;

	/**
	 * Persistir Cupón de un cliente
	 * @param cupon
	 * @return
	 * @throws LocalizedException
	 */
	ClienteCupon saveClienteCupon(ClienteCupon cupon) throws LocalizedException;

	/**
	 * Eliminar un cupón de un cliente.
	 * @param cupon
	 * @throws LocalizedException
	 */
	void deleteClienteCupon(ClienteCupon cupon) throws LocalizedException;

}
