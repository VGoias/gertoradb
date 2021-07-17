package com.sb.gestoradb.dtos;

import java.io.Serializable;

import com.sb.gestoradb.domain.Unity;

public class UnityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
