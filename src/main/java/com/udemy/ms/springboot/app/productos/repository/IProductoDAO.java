package com.udemy.ms.springboot.app.productos.repository;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ms.springboot.model.commons.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long> {

}