package com.pan.cristiano.UserStories.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "CPF"))
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	private String nome;		
	private String cpf;	
	private String logradouro;
	private String cep;
	private String estado;
	private String municipio;
	private String pais;

	public Cliente(String Nome, String cPF, String Logradouro,String cEP, String Estado, String Municipio, String Pais )
	{
		nome= Nome;	
		cpf = cPF;
		logradouro = Logradouro;
		cep = cEP;
		estado = Estado;
		municipio = Municipio;
		pais = Pais;
	}
	
	public Cliente() {};
	
	


	
}
