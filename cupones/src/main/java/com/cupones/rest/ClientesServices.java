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

import com.cupones.services.cliente.ClientesDataServices;
import com.cupones.services.cliente.ClientesDataServicesImpl;
import com.javalego.exception.LocalizedException;

import entities.Cliente;
import entities.ClienteCupon;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientesServices {

	private static final Logger logger = Logger.getLogger(ClientesServices.class.getCanonicalName());

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	private ClientesDataServicesImpl data;	
	
	@GET
	public Collection<Cliente> getList() throws LocalizedException {
		try {
			logger.info("Loading objects");
			return getData().getClientes();
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/search/{query}")
	public List<Cliente> search(@PathParam("query") String query) throws LocalizedException {
		logger.info("Searching by: " + query);
		List<Cliente> list = new ArrayList<Cliente>();
		return list;
	}

	@POST
	@Path("/save")
	public Cliente save(Cliente cliente) throws LocalizedException {
		logger.info("Save: " + cliente.getNombre());
		try {
			return getData().saveCliente(cliente);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@POST
	@Path("/save/cupon")
	public ClienteCupon save(ClienteCupon cupon) throws LocalizedException {
		logger.info("Save: " + cupon.getCupon().getNombre());
		try {
			return getData().saveClienteCupon(cupon);
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
			getData().deleteCliente(getData().getCliente(id));
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/delete/cupon/{id}")
	public void deleteCupon(@PathParam("id") long id) throws LocalizedException {
		logger.info("Remove: " + id);
		try {
			getData().deleteClienteCupon(getData().getClienteCupon(id));
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("{id}")
	public Cliente getCuponById(@PathParam("id") long id) throws LocalizedException {
		System.out.println("Getting by id: " + id);
		try {
			return getData().getCliente(id);
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
	private synchronized ClientesDataServices getData() {
		
		if (data == null) {
			data = new ClientesDataServicesImpl();
		}
		
		return data;
	}
}
