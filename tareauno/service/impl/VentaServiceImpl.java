package com.tareauno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tareauno.model.Venta;
import com.tareauno.repo.IGenericRepo;
import com.tareauno.repo.IVentaRepo;
import com.tareauno.service.IVentaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IVentaRepo ventaRepo;

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return ventaRepo;
	}

	@Override
	public Venta registrarTransaccional(Venta venta) throws Exception {        
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		return ventaRepo.save(venta);
	}

}
