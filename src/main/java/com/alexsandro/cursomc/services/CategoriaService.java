package com.alexsandro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexsandro.cursomc.domain.Categoria;
import com.alexsandro.cursomc.repositories.CategoriaRepository;
import com.alexsandro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); //caso o id esteja diferente de nulo e ja exista um registro na base com o mesmo id, a operacao entendera que eh um update ao inves de um insert
		return repo.save(obj);
	}
	
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj); //como o id nao esta nulo, ele faz update
	}

	
}