package com.udemy.ms.springboot.app.productos.service;

import java.util.List;

import com.udemy.ms.springboot.model.commons.entity.Producto;

public interface IProductoService {

	public List<Producto> findAllProducts();
	
	public Producto findProductById(Long id);
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);
}
