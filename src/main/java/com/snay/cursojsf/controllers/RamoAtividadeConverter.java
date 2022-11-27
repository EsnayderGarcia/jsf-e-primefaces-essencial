package com.snay.cursojsf.controllers;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.snay.cursojsf.models.RamoAtividade;

public class RamoAtividadeConverter implements Converter {
	
	private List<RamoAtividade> ramoAtividades;
	
	public RamoAtividadeConverter(List<RamoAtividade> ramoAtividades) {
		this.ramoAtividades = ramoAtividades;
	}

	/*Esté método será chamado quando houver alguma submissão do form, para que o componente autocomplete envie a string referente ao Ramo Atividade informado*/	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null) 
			return null;
		  
		Long id = Long.valueOf(value);
		
		return ramoAtividades.stream()
							 .filter(ra -> ra.getId().equals(id))
							 .findFirst()
							 .get();
	}

	/*Dizemos para a aplicação que sempre que acessarmos o obejto ramo atividade, a chave string que o representará será o seu id*/
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return null;
		
		RamoAtividade ramoAtividade = (RamoAtividade) value;
		return ramoAtividade.getId().toString();
	}

}
