package com.hugo.myapi.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = " Campo NOME é mandatório")
	@Length(min = 3 , max =  100 , message = " O nome deve ter entre 3 e 100 caracteres")
	private String nome;

	@NotEmpty(message = " Campo LOGIN é mandatório")
	@Length(min = 3 , max =  100 , message = " O login deve ter entre 3 e 100 caracteres")
	private String login;

	@NotEmpty(message = " Campo SENHA é mandatório")
	@Length(min = 3 , max =  100 , message = " A senha deve ter entre 3 e 100 caracteres")
	private String senha;

	public Usuarios() {
		super();
	}

	public Usuarios(Integer id, String nome, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}

	public void setId(Integer id) {
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}



}
