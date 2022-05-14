package com.aps.bethstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aps.bethstore.domain.Produto;
import com.aps.bethstore.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow();
	}

	public Produto insert(Produto obj) {
		obj.setIdProduto(null);
		return repo.save(obj);
	}

	public Produto update(Produto obj) {
		Produto newObj = find(obj.getIdProduto());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public List<Produto> findAll(){
		return repo.findAll();
	}

	private void updateData(Produto newObj, Produto obj) {
		newObj.setDescricao(obj.getDescricao());
	}
}