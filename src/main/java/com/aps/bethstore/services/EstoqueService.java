package com.aps.bethstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aps.bethstore.domain.Estoque;
import com.aps.bethstore.repositories.EstoqueRepository;
import com.aps.bethstore.services.exceptions.DataIntegrityException;
import com.aps.bethstore.services.exceptions.ObjectNotFoundException;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;
	
	public Estoque find(Integer id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Estoque.class.getName()));
	}
	
	public Estoque insert(Estoque obj) {
		obj.setIdEstoque(null);
		return repo.save(obj);
	}
	
	public Estoque update (Estoque obj){
		Estoque newObj = find(obj.getIdEstoque());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete (Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir esse estoque pois ainda possui produtos!");
		}
	}
	
	
	private void updateData(Estoque newObj, Estoque obj) {
		newObj.setQtdProduto(obj.getQtdProduto());
	}
}
