package com.tareauno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tareauno.model.Persona;
import com.tareauno.repo.IGenericRepo;
import com.tareauno.repo.IPersonaRepo;
import com.tareauno.service.IPersonaService;

@Service
public class PersonaServiceImpl extends CRUDImpl< Persona, Integer> implements IPersonaService{

	@Autowired
	private IPersonaRepo personaRepo;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() {
		return personaRepo;
	}

}
