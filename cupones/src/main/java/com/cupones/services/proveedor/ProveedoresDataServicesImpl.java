package com.cupones.services.proveedor;

import java.util.Collection;

import com.javalego.data.DataContext;
import com.javalego.data.DataProvider;
import com.javalego.entity.Entity;
import com.javalego.exception.CommonErrors;
import com.javalego.exception.LocalizedException;

import entities.Proveedor;

public class ProveedoresDataServicesImpl implements ProveedoresDataServices {

	@Override
	public Proveedor newInstanceProveedor() throws LocalizedException {
		return new Proveedor();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Proveedor> getProveedores() throws LocalizedException {
		return (Collection<Proveedor>)getData().getList(Proveedor.class);
	}

	@Override
	public Proveedor getProveedor(long id) throws LocalizedException {
		return (Proveedor)getData().getObject(Proveedor.class, id);
	}

	@Override
	public Proveedor saveProveedor(Proveedor proveedor) throws LocalizedException {
		return (Proveedor)getData().save(proveedor);
	}

	@Override
	public void deleteProveedor(Proveedor proveedor) throws LocalizedException {
		getData().delete(proveedor);
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
