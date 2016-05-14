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

import com.cupones.services.cupon.CuponesDataServices;
import com.cupones.services.cupon.CuponesDataServicesImpl;
import com.javalego.exception.LocalizedException;

import entities.Cupon;

@Path("/cupones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuponesServices {

	private static final Logger logger = Logger.getLogger(CuponesServices.class.getCanonicalName());

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	private CuponesDataServices data;	
	
	@GET
	public Collection<Cupon> getList() throws LocalizedException {
		try {
			logger.info("Loading objects");
			return getData().getCupones();
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/proveedor/{id}")
	public Collection<Cupon> getList(@PathParam("id") long id) throws LocalizedException {
		try {
			logger.info("Loading objects");
			return getData().getCupones(id);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("/search/{query}")
	public List<Cupon> search(@PathParam("query") String query) throws LocalizedException {
		logger.info("Searching by: " + query);
		List<Cupon> list = new ArrayList<Cupon>();
		return list;
	}

	@POST
	@Path("/save")
	public Cupon save(Cupon cupon) throws LocalizedException {
		logger.info("Save: " + cupon.getDescripcion());
		try {
			return getData().saveCupon(cupon);
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
			getData().deleteCupon(getData().getCupon(id));
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("{id}")
	public Cupon getCuponById(@PathParam("id") long id) throws LocalizedException {
		System.out.println("Getting by id: " + id);
		try {
			return getData().getCupon(id);
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
	private synchronized CuponesDataServices getData() throws LocalizedException {
		
		if (data == null) {
			data = new CuponesDataServicesImpl();
		}
		
		return data;
	}
}
