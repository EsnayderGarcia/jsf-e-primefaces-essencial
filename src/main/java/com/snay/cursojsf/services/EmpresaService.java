package com.snay.cursojsf.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.snay.cursojsf.models.Empresa;
import com.snay.cursojsf.repositorios.EmpresaRepositorio;
import com.snay.cursojsf.uteis.Transacional;

public class EmpresaService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepositorio empresaRepositorio;
	
	@Transacional
	public void remover(Long id) {
		empresaRepositorio.remover(id);
	}
	
	@Transacional
	public Empresa salvar(Empresa empresa) {
		return empresaRepositorio.salvar(empresa);
	}
	
	public Empresa buscarPorId(Long id) {
		return empresaRepositorio.buscarPorId(id);
	}
	
	public List<Empresa> buscarTodas() {
		return empresaRepositorio.buscarTodas();
	}
	
	public List<Empresa> pesquisar(String nomeFantasia) {
		return empresaRepositorio.pesquisar(nomeFantasia);
	}
	
}
