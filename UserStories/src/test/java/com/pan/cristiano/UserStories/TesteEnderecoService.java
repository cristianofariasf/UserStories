package com.pan.cristiano.UserStories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pan.cristiano.UserStories.Models.Endereco;
import com.pan.cristiano.UserStories.Models.Estado;
import com.pan.cristiano.UserStories.Models.Municipio;
import com.pan.cristiano.UserStories.Service.EnderecoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteEnderecoService {
	
	@Autowired
	EnderecoService endereco;
	
	@Test
	public void contextLoads() throws JsonParseException, JsonMappingException, IOException 
	{		
		TesteBuscaCep();	
		TesteBuscaEstados();
		TesteBuscaMunicipios();
	}
	
	
	public void TesteBuscaCep() throws JsonParseException, JsonMappingException, IOException 
	{
		String enderecoResultado = endereco.ConsultaPorCep("02991120");
		ObjectMapper mapper = new ObjectMapper();
		String rua = "Rua Leila Diniz";
		Endereco res = mapper.readValue(enderecoResultado, Endereco.class);
		 assertEquals(rua, res.getLogradouro());			
	}
	
	public void TesteBuscaEstados() throws JsonParseException, JsonMappingException, IOException 
	{		
		List<Estado> estados =endereco.ConsultaEstados();	
		 assertEquals(true, estados.size() >0);
		
	}
	
	public void TesteBuscaMunicipios() throws JsonParseException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String municipiosJson = endereco.ConsultaMunicipio("35");	
		
		List<Municipio> municipios = mapper.readValue(municipiosJson, new TypeReference<List<Municipio>>(){});
		 assertEquals(true, municipios.size() >0);
		
	}
	
}
