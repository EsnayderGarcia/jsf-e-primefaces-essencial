package com.snay.cursojsf.repositorios;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.snay.cursojsf.models.RamoAtividade;

public class RamoAtividadeRepositorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<RamoAtividade> pesquisar(String termo) {
		String hql = "FROM RamoAtividade ra WHERE UPPER(ra.descricao) LIKE UPPER(:termo)";
		
		TypedQuery<RamoAtividade> query = manager.createQuery(hql, RamoAtividade.class);
		List<RamoAtividade> RamoAtividades = query
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
		
		return RamoAtividades;
	}
	
}
