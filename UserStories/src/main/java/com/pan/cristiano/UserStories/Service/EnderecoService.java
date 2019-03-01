package com.pan.cristiano.UserStories.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pan.cristiano.UserStories.Models.Estado;

@Service
public class EnderecoService {

	
	
	public String ConsultaPorCep(String cep) 
	{		
		String url = "https://viacep.com.br/ws/" + cep + "/json";
		return ConsultaRestService(url);		
	}
	
	public List<Estado> ConsultaEstados() throws JsonParseException, JsonMappingException, IOException 
	{		
		  RestTemplate restTemplate = new RestTemplate();
		  String quote = restTemplate.getForObject("https://servicodados.ibge.gov.br/api/v1/localidades/estados/", String.class);
		  ObjectMapper mapper = new ObjectMapper();
		  List<Estado> estadosLista = mapper.readValue(quote, new TypeReference<List<Estado>>(){});
		  Estado saopaulo = estadosLista.stream().filter(estado -> "SP".equals(estado.getSigla())).findAny().orElse(null);
		  Estado rio = estadosLista.stream().filter(estado -> "RJ".equals(estado.getSigla())).findAny().orElse(null);		  
		  estadosLista.remove(saopaulo);
		  estadosLista.remove(rio);		  
		  List<Estado> listaEstadoOrdenada = new ArrayList<>();
		  listaEstadoOrdenada.add(saopaulo);
		  listaEstadoOrdenada.add(rio);		  
		   Collections.sort(estadosLista, new Comparator<Estado>() {
		        @Override
		        public int compare(Estado e1, Estado e2) {
		            return e1.getNome().compareTo(e2.getNome());
		        }
		    });		  		  
		  listaEstadoOrdenada.addAll(estadosLista);
	      return listaEstadoOrdenada;       
	}
	
	public String ConsultaMunicipio(String idMunicipio) 
	{		
		String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+idMunicipio +"/municipios";
		return ConsultaRestService(url);		
	}
	
	
	public String ConsultaRestService(String url) 
	{
		
        RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject(url, String.class);
        return quote;	
		
	}
}
