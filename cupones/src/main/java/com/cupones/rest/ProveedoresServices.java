package com.cupones.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.cupones.services.proveedor.ProveedoresDataServices;
import com.cupones.services.proveedor.ProveedoresDataServicesImpl;
import com.javalego.exception.LocalizedException;

import entities.Proveedor;

@Path("/proveedores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedoresServices {

	private static final Logger logger = Logger.getLogger(ProveedoresServices.class.getCanonicalName());

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	private ProveedoresDataServicesImpl data;	
	
	@GET
	public Collection<Proveedor> getList() throws LocalizedException {
		try {
			logger.info("Loading objects");
			return getData().getProveedores();
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/search/{query}")
	public List<Proveedor> search(@PathParam("query") String query) throws LocalizedException {
		logger.info("Searching by: " + query);
		List<Proveedor> list = new ArrayList<Proveedor>();
		return list;
	}

	@POST
	@Path("/save")
	public Proveedor save(Proveedor proveedor) throws LocalizedException {
		logger.info("Save: " + proveedor.getNombre());
		try {
			return getData().saveProveedor(proveedor);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/delete/{id}")
	public void delete(@PathParam("id") long id) throws LocalizedException {
		logger.info("Remove: " + id);
		try {
			getData().deleteProveedor(getData().getProveedor(id));
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("{id}")
	public Proveedor getCuponById(@PathParam("id") long id) throws LocalizedException {
		System.out.println("Getting by id: " + id);
		try {
			return getData().getProveedor(id);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	/**
	 * Servicio de datos
	 * 
	 * @return
	 */
	private synchronized ProveedoresDataServices getData() {
		
		if (data == null) {
			data = new ProveedoresDataServicesImpl();
		}
		
		return data;
	}
}
