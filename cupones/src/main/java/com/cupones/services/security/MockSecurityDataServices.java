package com.cupones.services.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.javalego.exception.LocalizedException;

import entities.Usuario;

public class MockSecurityDataServices implements SecurityDataServices {

	private static final List<Usuario> DUMMY = new ArrayList<Usuario>();

	@Override
	public Usuario newInstanceUser() throws LocalizedException {
		return new Usuario();
	}

	@Override
	public Collection<Usuario> getUsers() throws LocalizedException {
		return DUMMY;
	}

	@Override
	public Usuario getUser(long id) throws LocalizedException {
		return DUMMY.get((int)id);
	}

	@Override
	public Usuario saveUser(Usuario user) throws LocalizedException {
		return null;
	}

	@Override
	public void deleteUser(Usuario user) throws LocalizedException {
	}

	@Override
	public boolean find(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario login(Usuario user) throws LocalizedException {
		return user;
	}

}
