package com.sb.gestoradb.domain;

import java.util.Date;
import java.util.Objects;

public class Player {

	private Integer id;
	private String nick;
	private Date birth;

	private Unity unity;

	public Player() {
		super();
	}

	public Player(Integer id, String nick, Date birth, Unity unity) {
		super();
		this.id = id;
		this.nick = nick;
		this.birth = birth;
		this.unity = unity;
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

	public Unity getUnity() {
		return unity;
	}

	public void setUnity(Unity unity) {
		this.unity = unity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id);
	}

}
