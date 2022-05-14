package com.aps.bethstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aps.bethstore.domain.Categoria;
import com.aps.bethstore.repositories.CategoriaRepository;
import com.aps.bethstore.services.exceptions.DataIntegrityException;
import com.aps.bethstore.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setIdCategoria(null);
		return repo.save(obj);
	}
	
	public Categoria update (Categoria obj){
		Categoria newObj = find(obj.getIdCategoria());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete (Integer id){
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos!");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setDescricao(obj.getDescricao());
	}
}
