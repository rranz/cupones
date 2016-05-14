package com.cupones.services.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.javalego.exception.LocalizedException;

import entities.Cliente;
import entities.ClienteCupon;

public class MockClientesDataServices implements ClientesDataServices {

	private static final List<Cliente> DUMMY = new ArrayList<Cliente>();

	static {
		DUMMY.add(new Cliente("carrefour@gmail.com", "123456"));
		DUMMY.add(new Cliente("restaurantemadrid@gmail.com", "123456"));
	}
	
	@Override
	public Cliente newInstanceCliente() throws LocalizedException {
		return new Cliente();
	}

	@Override
	public Collection<Cliente> getClientes() throws LocalizedException {
		return DUMMY;
	}

	@Override
	public Cliente getCliente(long id) throws LocalizedException {
		return DUMMY.get((int)id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) throws LocalizedException {
		return null;
	}

	@Override
	public void deleteCliente(Cliente cliente) throws LocalizedException {
	}

	@Override
	public ClienteCupon saveClienteCupon(ClienteCupon cupon) throws LocalizedException {
		return null;
	}

	@Override
	public void deleteClienteCupon(ClienteCupon cupon) throws LocalizedException {
	}

	@Override
	public ClienteCupon getClienteCupon(long id) throws LocalizedException {
		// TODO Auto-generated method stub
		return null;
	}

}
