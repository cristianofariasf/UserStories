package com.pan.cristiano.UserStories.Models;

import java.util.Date;

public class ClienteViewModel {

public ClienteViewModel() {}
	public ClienteViewModel(String cPF, String Logradouro,String cEP, String Estado, String Municipio, String Pais )
	{	
		cpf = cPF;
		logradouro = Logradouro;
		cep = cEP;
		estado = Estado;
		municipio = Municipio;
		pais = Pais;
	}
	
	
	private String cpf;	
	private String logradouro;
	private String cep;
	private String estado;
	private String municipio;
	
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
	private String pais;

}
