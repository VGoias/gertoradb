package com.sb.gestoradb.dtos;

import java.io.Serializable;
import java.util.Date;

import com.sb.gestoradb.domain.Player;

public class PlayerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nick;
	private Date birth;
	
	public PlayerDTO() {
		super();
	}

	public PlayerDTO(Player obj) {
		super();
		this.id = obj.getId();
		this.nick = obj.getNick();
		this.birth = obj.getBirth();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
}
