package com.tareauno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareauno.model.Producto;
import com.tareauno.repo.IGenericRepo;
import com.tareauno.repo.IProductoRepo;
import com.tareauno.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService{
	
	@Autowired
	private IProductoRepo productoRepo;

	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		return productoRepo;
	}

}
