package com.cupones.services.cupon;

import java.util.Collection;

import com.javalego.data.DataContext;
import com.javalego.data.DataProvider;
import com.javalego.entity.Entity;
import com.javalego.exception.CommonErrors;
import com.javalego.exception.LocalizedException;

import entities.Cupon;

public class CuponesDataServicesImpl implements CuponesDataServices {

	@Override
	public Cupon newInstanceCupon() throws LocalizedException {
		return new Cupon();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cupon> getCupones() throws LocalizedException {
		return (Collection<Cupon>)getData().getList(Cupon.class);
	}

	@Override
	public Cupon getCupon(long id) throws LocalizedException {
		return (Cupon)getData().getObject(Cupon.class, id);
	}

	@Override
	public Cupon saveCupon(Cupon cupon) throws LocalizedException {
		return (Cupon)getData().save(cupon);
	}

	@Override
	public void deleteCupon(Cupon cupon) throws LocalizedException {
		getData().delete(cupon);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cupon> getCupones(long id) throws LocalizedException {
		return (Collection<Cupon>)getData().getList(Cupon.class, "proveedor =  " + id);
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
