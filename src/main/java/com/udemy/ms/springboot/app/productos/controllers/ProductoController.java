package com.udemy.ms.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.ms.springboot.model.commons.entity.Producto;
import com.udemy.ms.springboot.app.productos.service.IProductoService;

@RestController
@RequestMapping(path = "/prd")
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listado(){
		return productoService.findAllProducts();
	}
	
	@GetMapping("/ver/{idProducto}")
	public Producto detalle(@PathVariable(name = "idProducto") Long id) throws Exception {
//Simulamos un error     
//		boolean flag = true;
//		if(flag) {
//			throw new Exception("Error al cargar el producto!");
//		}
		
//Simulamos un error de timeOut
//		try {
//			Thread.sleep(2000L);	
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return productoService.findProductById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED) 
	public Producto agregarProducto(@RequestBody Producto entity) {
		return productoService.save(entity);
	}
	
	@PutMapping("/editar/{idProducto}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto editarProducto( @RequestBody Producto entity, @PathVariable(name = "idProducto") Long id) {
		Producto productoDB = productoService.findProductById(id);
		if(productoDB != null) {
			productoDB.setNombre(entity.getNombre());
			productoDB.setPrecio(entity.getPrecio());
			return productoService.save(productoDB);
		} else 
			return null;
	}
	
	@DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable(value = "id") Long idProducto) {
		productoService.deleteById(idProducto);
	}
	
	
}
