package com.cupones.services.proveedor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.javalego.exception.LocalizedException;

import entities.Proveedor;

public class MockProveedoresDataServices implements ProveedoresDataServices {

	private static final List<Proveedor> DUMMY = new ArrayList<Proveedor>();

	static {
		DUMMY.add(new Proveedor("Carrefour", "carrefour@gmail.com"));
		DUMMY.add(new Proveedor("Restaurante Madrid", "restaurantemadrid@gmail.com"));
	}
	
	@Override
	public Proveedor newInstanceProveedor() throws LocalizedException {
		return new Proveedor();
	}

	@Override
	public Collection<Proveedor> getProveedores() throws LocalizedException {
		return DUMMY;
	}

	@Override
	public Proveedor getProveedor(long id) throws LocalizedException {
		return DUMMY.get((int)id);
	}

	@Override
	public Proveedor saveProveedor(Proveedor proveedor) throws LocalizedException {
		return null;
	}

	@Override
	public void deleteProveedor(Proveedor proveedor) throws LocalizedException {
	}

}
