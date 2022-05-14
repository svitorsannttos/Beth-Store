package com.aps.bethstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aps.bethstore.domain.Produto;
import com.aps.bethstore.services.ProdutoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/produtos")
@Api(value="API REST Produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		
		Produto obj = service.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
