package com.sb.gestoradb.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sb.gestoradb.domain.Unity;

public class UnityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O nome é necessário. Digite como a Unidade é conhecida popularmente.")
	@Length(min=3, max=100, message = "O nome deve conter entre 3 e 100 caracteres. Por Favor, digite outro.")
	private String name;
	
	@NotEmpty(message = "Uma breve descrição é necessária. Digite os meios de contato e o que a unidade oferece aos seus clientes.")
	@Length(min=5, max=2000000, message = "A descrição deve conter entre 5 e 2.000.000 caracteres. Por Favor, corrija o texto.")
	private String description;
	
	public UnityDTO() {
		super();
	}
	
	public UnityDTO(Unity obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
