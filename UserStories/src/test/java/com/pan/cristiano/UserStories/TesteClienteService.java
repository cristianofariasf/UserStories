package com.pan.cristiano.UserStories;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pan.cristiano.UserStories.Models.Cliente;
import com.pan.cristiano.UserStories.Models.ClienteViewModel;
import com.pan.cristiano.UserStories.Service.ClienteService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteClienteService {

	@Autowired
	ClienteService cli;
	
	@Test
	public void contextLoads() {
		
		TesteExecutaInsert(); 
		TesteExecutaBusca();
		TesteExecutaUpdate();	 		   
	}
	
	
	public void TesteExecutaInsert() 
	{	
			  
			  Cliente cl1 = new Cliente("Cristiano","22794415868","Rua Leila Diniz","02991120", "São Paulo", "SP", "Brasil"); 
			  assertSame(cl1.getCpf(), cli.IncluirCliente(cl1).getCpf());		
	}
	
	public void TesteExecutaBusca() 
	{				  
		 assertSame("Cristiano", cli.ListarPorCPF("22794415868").getNome());	
	}
	
	
	public void TesteExecutaUpdate() 
	{				  	
		ClienteViewModel cliup = new ClienteViewModel("22794415868", "Av Egenheiro Luis Carlos Berrini","04571000", "São Paulo", "SP", "Brasil");
		assertSame("04571000", cli.AtualizarCLiente(cliup).getCep());	
	}
}
