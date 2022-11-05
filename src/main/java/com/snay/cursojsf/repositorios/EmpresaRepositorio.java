package com.snay.cursojsf.repositorios;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.snay.cursojsf.models.Empresa;

public class EmpresaRepositorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public EmpresaRepositorio() {}

	public EmpresaRepositorio(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa buscarPorId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public void remover(Long id) {
		var entity = buscarPorId(id);
		
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public List<Empresa> pesquisar(String nomeFantasia) {
		String hql = "SELECT e FROM Empresa e WHERE e.nomeFantasia LIKE :nomeFantasia";
		TypedQuery<Empresa> query = manager.createQuery(hql, Empresa.class);
		List<Empresa> empresas = query
				.setParameter("nomeFantasia", "%"+nomeFantasia+"%")
				.getResultList();
		
		return empresas;
	}
	
	public Empresa salvar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
}
