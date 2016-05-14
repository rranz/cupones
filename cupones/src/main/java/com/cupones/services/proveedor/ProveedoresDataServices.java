package com.cupones.services.proveedor;

import java.util.Collection;

import com.javalego.data.BusinessService;
import com.javalego.exception.LocalizedException;

import entities.Proveedor;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public interface ProveedoresDataServices extends BusinessService {

	/**
	 * Generar un nuevo Proveedor para su edición.
	 * 
	 * @return
	 */
	Proveedor newInstanceProveedor() throws LocalizedException;

	/**
	 * Listado de Proveedores
	 * 
	 * @return
	 * @throws LocalizedException 
	 */
	Collection<Proveedor> getProveedores() throws LocalizedException;

	/**
	 * Obtener un Proveedor por su id
	 * @param id
	 * @return
	 * @throws LocalizedException 
	 */
	Proveedor getProveedor(long id) throws LocalizedException;
	
	/**
	 * Persistir proveedor
	 * @param proveedor
	 * @return
	 * @throws LocalizedException
	 */
	Proveedor saveProveedor(Proveedor proveedor) throws LocalizedException;

	/**
	 * Eliminar un cupón.
	 * @param proveedor
	 * @throws LocalizedException
	 */
	void deleteProveedor(Proveedor proveedor) throws LocalizedException;

}
