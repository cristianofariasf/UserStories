package com.pan.cristiano.UserStories.Controllers;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pan.cristiano.UserStories.Models.Estado;
import com.pan.cristiano.UserStories.Service.EnderecoService;

@RestController("endereco")
public class EnderecoController {

	@Autowired
	EnderecoService _endereco;

	@RequestMapping(value = "endereco/cep/{cep}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getCep(@PathVariable("cep") String cep) {
		
		try {
		String endereco = _endereco.ConsultaPorCep(cep);
		return new ResponseEntity<String>(endereco, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "endereco/consultaEstados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Estado> > getEstados() throws JsonParseException, JsonMappingException, IOException {
		try {
		List<Estado>  estados = _endereco.ConsultaEstados();
		return new ResponseEntity<List<Estado> >(estados, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<List<Estado>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	@RequestMapping(value = "endereco/consultaMunicipio/{idEstado}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> getMunicipios(@PathVariable("idEstado") String idEstado) throws JsonMappingException, IOException {
		try {
		String  municipio = _endereco.ConsultaMunicipio(idEstado);
		return new ResponseEntity<String >(municipio, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
