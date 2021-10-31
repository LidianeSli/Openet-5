package br.com.openet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@Column(name = "usuariosid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuariosid;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nascimento")
	private Date nascimento;
	
	@Column(name = "cursoid")
	private Integer cursoid;
	
	@Column(name = "periodo")
	private String periodo;
	
	public Integer getUsuariosid() {
		return usuariosid;
	}

	public void setUsuariosid(Integer usuariosid) {
		this.usuariosid = usuariosid;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Integer getCursoid() {
		return cursoid;
	}

	public void setCursoid(Integer cursoid) {
		this.cursoid = cursoid;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Usuario() {
		
	}
	
	
	
}

