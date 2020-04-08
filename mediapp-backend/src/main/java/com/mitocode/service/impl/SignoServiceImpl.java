package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mitocode.model.Signos;
import com.mitocode.repo.ISignoRepo;
import com.mitocode.service.ISignoService;

@Service
public class SignoServiceImpl implements ISignoService{

	@Autowired
	private ISignoRepo repo;
	
	@Override
	public Signos registrar(Signos obj) {
		return repo.save(obj);
	}

	@Override
	public Signos modificar(Signos obj) {		
		return repo.save(obj);
	}

	@Override
	public List<Signos> listar() {
		// TODO Auto-generated method stub
		return  repo.findAll();
	}

	@Override
	public Signos listarPorId(Integer id) {
		Optional<Signos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Signos();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;				
	}

	@Override
	public Page<Signos> listarPageable(Pageable pageable) { 
		
		pageable.getSortOr(Sort.by("id").ascending());
		return repo.findAll(pageable);
	}

}
