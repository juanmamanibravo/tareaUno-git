package com.tareauno.service;


import com.tareauno.model.*;

public interface IVentaService extends ICRUD<Venta, Integer>{
	
	Venta registrarTransaccional(Venta venta) throws Exception;

}
