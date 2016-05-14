package com.cupones.services.security;

import java.util.Collection;

import com.javalego.data.DataContext;
import com.javalego.data.DataProvider;
import com.javalego.entity.Entity;
import com.javalego.exception.CommonErrors;
import com.javalego.exception.LocalizedException;

import entities.Usuario;

public class SecurityDataServicesImpl implements SecurityDataServices {

	@Override
	public Usuario newInstanceUser() throws LocalizedException {
		return new Usuario();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Usuario> getUsers() throws LocalizedException {
		return (Collection<Usuario>) getData().getList(Usuario.class);
	}

	@Override
	public Usuario getUser(long id) throws LocalizedException {
		return (Usuario) getData().getObject(Usuario.class, id);
	}

	@Override
	public Usuario saveUser(Usuario user) throws LocalizedException {
		return (Usuario) getData().save(user);
	}

	@Override
	public void deleteUser(Usuario user) throws LocalizedException {
		getData().delete(user);
	}

	private DataProvider<Entity> getData() throws LocalizedException {
		if (DataContext.getProvider() == null) {
			throw new LocalizedException(CommonErrors.DATABASE_ERROR);
		}
		else {
			return DataContext.getProvider();
		}
	}

	@Override
	public boolean find(Usuario user) throws LocalizedException {
		return getData().getList(Usuario.class, "nombre = '" + user.getNombre() + "' or email = '" + user.getEmail() + "'").size() > 0;
	}

	@Override
	public Usuario login(Usuario user) throws LocalizedException {
		Usuario usuario = (Usuario) getData().getObject(Usuario.class, "(nombre = '" + user.getNombre() + "' or email = '" + user.getEmail() + "') and password = '" + user.getPassword() + "'");
		if (usuario == null) {
			throw new LocalizedException("Usuario o contraseña inexistentes.");
		}
		return usuario;
	}
}
