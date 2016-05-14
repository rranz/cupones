package com.cupones.services.cupon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.javalego.exception.LocalizedException;

import entities.Cupon;

public class MockCuponesDataServices implements CuponesDataServices {

	private static final List<Cupon> DUMMY = new ArrayList<Cupon>();

	static {
		DUMMY.add(new Cupon("Corte de pelo", "Corte de pelo a tijera."));
		DUMMY.add(new Cupon("Lavado de pelo", "Lavado de pelo con champú de huevo"));
		DUMMY.add(new Cupon("Manicura", "Manicura de piés y manos"));
	}
	
	@Override
	public Cupon newInstanceCupon() throws LocalizedException {
		return new Cupon();
	}

	@Override
	public Collection<Cupon> getCupones() throws LocalizedException {
		return DUMMY;
	}

	@Override
	public Cupon getCupon(long id) throws LocalizedException {
		return DUMMY.get((int)id);
	}

	@Override
	public Cupon saveCupon(Cupon cupon) throws LocalizedException {
		return null;
	}

	@Override
	public void deleteCupon(Cupon cupon) throws LocalizedException {
	}

	@Override
	public Collection<Cupon> getCupones(long id) throws LocalizedException {
		return DUMMY;
	}

}
