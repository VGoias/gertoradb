package com.sb.gestoradb.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sb.gestoradb.domain.Player;

public class PlayerDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "O nome/apelido é necessário. Digite como gosta de ser chamado.")
	@Length(min=3, max=100, message = "O valor informado deve conter entre 3 e 100 caracteres. Por Favor, digite outro.")
	private String nick;
	@NotEmpty(message = "A Data de nascimento é importante para diferenciar você de outros jogadores.")
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
