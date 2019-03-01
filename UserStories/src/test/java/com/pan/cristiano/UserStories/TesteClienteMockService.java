package com.pan.cristiano.UserStories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnitRunner;


import com.pan.cristiano.UserStories.Models.Cliente;

import com.pan.cristiano.UserStories.Service.ClienteService;
@RunWith(MockitoJUnitRunner.class)
public class TesteClienteMockService {
	@Mock
	private ClienteService cliServ;	 
	
	private static Cliente cliente1 ;
	private static Cliente cliente2 ;
    @Before
	public void setup() 
	{	
		  ClienteService cliServ = mock(ClienteService.class);			  
		  Date dt= new Date();
		  cliente1 = new Cliente("Cristiano","22794415868","Rua Leila Diniz","02991120", "São Paulo", "SP", "Brasil");
		  cliente2 = new Cliente("Juliana","23771853712","Av Engenheiro Luis Carlos Berrini","04571000", "São Paulo", "SP", "Brasil");
	}		
	 
	 @Test
	  public void testeListarUsuarios() throws Exception {
		 	
		  List<Cliente> clientes = new ArrayList<>();
		  clientes.add(cliente1);
		  clientes.add(cliente2);		
		  Mockito.when(cliServ.ListarTodos()).thenReturn(clientes);
		  assertEquals(2, cliServ.ListarTodos().size());
	 }
	 @Test
	  public  void testeListarUsuarioCPF() throws Exception {		 
		 
		when(cliServ.ListarPorCPF("22794415868")).thenReturn(cliente1);
		  
		assertEquals("22794415868", cliServ.ListarPorCPF("22794415868").getCpf());
		 
	 }
	

}
