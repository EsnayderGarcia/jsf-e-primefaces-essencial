package com.snay.cursojsf.repositorios;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.snay.cursojsf.enumerations.TipoEmpresa;
import com.snay.cursojsf.models.Empresa;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		
		var	empresa = new Empresa(null, "Vasp", "VaspDoido", "111111111111111111", LocalDate.parse("2022-11-04"));
		empresa.setTipoEmpresa(TipoEmpresa.MEI);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso-jsfPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		empresa = em.merge(empresa);
		em.getTransaction().commit();
		
		System.out.println(em.find(Empresa.class, empresa.getId()));

	}
	
}
