package com.snay.cursojsf.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("curso-jsfPU");
		EntityManager em = emf.createEntityManager();
		
		EmpresaRepositorio empresaRepositorio = new EmpresaRepositorio(em);
		
		System.out.println(empresaRepositorio.pesquisar("Ma"));

	}
	
}
