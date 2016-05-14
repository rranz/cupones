package com.cupones.services.cupon;

import java.util.Collection;

import com.javalego.data.BusinessService;
import com.javalego.exception.LocalizedException;

import entities.Cupon;

/**
 * Back-end service interface for retrieving and updating product data.
 */
public interface CuponesDataServices extends BusinessService {

	/**
	 * Generar un nuevo Cupón para su edición.
	 * 
	 * @return
	 */
	Cupon newInstanceCupon() throws LocalizedException;

	/**
	 * Listado de cupones
	 * 
	 * @return
	 * @throws LocalizedException 
	 */
	Collection<Cupon> getCupones() throws LocalizedException;

	/**
	 * Listado de cupones de un proveedor
	 * 
	 * @param id id del proveedor
	 * @return
	 * @throws LocalizedException 
	 */
	Collection<Cupon> getCupones(long id) throws LocalizedException;

	/**
	 * Obtener un cupon por su id
	 * @param id
	 * @return
	 * @throws LocalizedException 
	 */
	Cupon getCupon(long id) throws LocalizedException;
	
	/**
	 * Persistir un cupón
	 * @param cupon
	 * @return
	 * @throws LocalizedException
	 */
	Cupon saveCupon(Cupon cupon) throws LocalizedException;

	/**
	 * Eliminar un cupón.
	 * @param cupon
	 * @throws LocalizedException
	 */
	void deleteCupon(Cupon cupon) throws LocalizedException;

}
