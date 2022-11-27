package com.snay.cursojsf.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.snay.cursojsf.enumerations.TipoEmpresa;
import com.snay.cursojsf.models.Empresa;
import com.snay.cursojsf.models.RamoAtividade;
import com.snay.cursojsf.services.EmpresaService;
import com.snay.cursojsf.services.RamoAtividadeService;

@ViewScoped
@Named
public class GestaoEmpresaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaService empresaService;
	
	@Inject
	private RamoAtividadeService ramoAtividadeService;
	
	private Empresa empresa = new Empresa();
	
	private List<Empresa> empresas = new ArrayList<>();
	
	private String termoPesquisa;
	
	private Converter ramoAtividadeConverter;
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	
	public void carregarEmpresas() {
		empresas = empresaService.buscarTodas();
	}
	
	public void salvar() {
		empresaService.salvar(empresa);
	}
	
	public void pesquisarEmpresa() {
		empresas = empresaService.pesquisar(termoPesquisa);
	}
	
	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> ramoAtividades =  ramoAtividadeService.pesquisar(termo); 
		ramoAtividadeConverter = new RamoAtividadeConverter(ramoAtividades);
		
		return ramoAtividades;
	}

}
























