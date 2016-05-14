package com.cupones.rest;

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

import com.cupones.services.security.SecurityDataServices;
import com.cupones.services.security.SecurityDataServicesImpl;
import com.javalego.exception.LocalizedException;

import entities.Usuario;

@Path("/security")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SecurityServices {

	private static final Logger logger = Logger.getLogger(SecurityServices.class.getCanonicalName());

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	private SecurityDataServicesImpl data;

	@POST
	@Path("/register")
	public Usuario register(Usuario user) throws LocalizedException {
		logger.info("Register user " + user.getNombre() + " ...");
		try {
			if (!getData().find(user)) {
				Usuario result = getData().saveUser(user);
				logger.info("User " + user.getNombre() + " registered");
				return result;
			}
			// Si el id de usuario tiene id es que proviene de oauth como facebook y no es necesario generar una excepción porque no es necesario registrar el usuario.
			else if (user.getId() != null) {
				return user;
			}
			else {
				logger.severe("Usuario o email ya existen.");
				throw new LocalizedException("Usuario o email ya existen.");
			}
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
			getData().deleteUser(getData().getUser(id));
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@GET
	@Path("{id}")
	public Usuario getUserById(@PathParam("id") long id) throws LocalizedException {
		System.out.println("Getting by id: " + id);
		try {
			return getData().getUser(id);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@POST
	@Path("/login")
	public Usuario login(Usuario user) throws LocalizedException {
		System.out.println("Loging: " + user.getNombre());
		try {
			return getData().login(user);
		}
		catch (LocalizedException e) {
			logger.severe(e.getLocalizedMessage());
			throw e;
		}
	}

	@POST
	@Path("/save")
	public Usuario save(Usuario user) throws LocalizedException {
		System.out.println("Saving data profile: " + user.getNombre());
		try {
			return getData().saveUser(user);
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
	private synchronized SecurityDataServices getData() {

		if (data == null) {
			data = new SecurityDataServicesImpl();
		}

		return data;
	}
}
