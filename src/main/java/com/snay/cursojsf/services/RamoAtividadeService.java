package com.snay.cursojsf.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.snay.cursojsf.models.RamoAtividade;
import com.snay.cursojsf.repositorios.RamoAtividadeRepositorio;

public class RamoAtividadeService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RamoAtividadeRepositorio ramoAtividadeRepositorio;
	
	public List<RamoAtividade> pesquisar(String termo) {
		return ramoAtividadeRepositorio.pesquisar(termo);
	}
	
}
