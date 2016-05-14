package com.cupones.services.cliente;

import java.util.Collection;

import com.javalego.data.DataContext;
import com.javalego.data.DataProvider;
import com.javalego.entity.Entity;
import com.javalego.exception.CommonErrors;
import com.javalego.exception.LocalizedException;

import entities.Cliente;
import entities.ClienteCupon;

public class ClientesDataServicesImpl implements ClientesDataServices {

	@Override
	public Cliente newInstanceCliente() throws LocalizedException {
		return new Cliente();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> getClientes() throws LocalizedException {
		return (Collection<Cliente>)getData().getList(Cliente.class);
	}

	@Override
	public Cliente getCliente(long id) throws LocalizedException {
		return (Cliente)getData().getObject(Cliente.class, id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) throws LocalizedException {
		return (Cliente)getData().save(cliente);
	}

	@Override
	public void deleteCliente(Cliente cliente) throws LocalizedException {
		getData().delete(cliente);
	}

	@Override
	public ClienteCupon saveClienteCupon(ClienteCupon cupon) throws LocalizedException {
		return (ClienteCupon)getData().save(cupon);
	}

	@Override
	public void deleteClienteCupon(ClienteCupon cupon) throws LocalizedException {
		getData().delete(cupon);
	}

	@Override
	public ClienteCupon getClienteCupon(long id) throws LocalizedException {
		return (ClienteCupon)getData().getObject(ClienteCupon.class, id);
	}

	private DataProvider<Entity> getData() throws LocalizedException {
		if (DataContext.getProvider() == null) {
			throw new LocalizedException(CommonErrors.DATABASE_ERROR);
		}
		else {
			return DataContext.getProvider();
		}
	}
}
