package com.udemy.ms.springboot.app.productos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.ms.springboot.model.commons.entity.Producto;
import com.udemy.ms.springboot.app.productos.repository.IProductoDAO;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoDAO productoDao;	
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllProducts() {
		return ((List<Producto>)productoDao.findAll())
				.stream()
				.map(prod -> {
					prod.setPort(Integer.valueOf(env.getProperty("local.server.port")));
//					prod.setPort(port);
					return prod;
				})
				.collect(Collectors.toList());		
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductById(Long id) {
		Producto prd = productoDao.findById(id).orElse(null);
		if(prd != null) {
			prd.setPort(port);
		}
		return prd;
	}

	@Override
	@Transactional	
	public Producto save(Producto entity) {
		return productoDao.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		productoDao.deleteById(id);
	}

}
