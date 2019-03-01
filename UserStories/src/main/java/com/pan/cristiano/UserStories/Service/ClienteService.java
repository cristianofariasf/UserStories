package com.pan.cristiano.UserStories.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.cristiano.UserStories.Models.Cliente;
import com.pan.cristiano.UserStories.Models.ClienteViewModel;
import com.pan.cristiano.UserStories.Repo.IClienteRepository;

@Service
public class ClienteService {
		  
	  @Autowired IClienteRepository icliRepo;
	  
	public  List<Cliente> ListarTodos() {

		 List<Cliente> cli = icliRepo.findAll();
		  
		 return cli;
	  }
	
	  
	  public Optional<Cliente> ListarPorId(long id) {

		 Optional<Cliente> cli = icliRepo.findById(id);
		  
		 return cli;
	  }
	
	  
	  public Cliente ListarPorCPF(String cpf) {
		 Cliente cli = icliRepo.findOneBycpf(cpf);		  
		 return cli;
	  }
	   
	  public Cliente AtualizarCLiente(ClienteViewModel cli) 
	  {
		  String cpf = cli.getCpf();
		  Cliente cliBusca = icliRepo.findOneBycpf(cpf);	
		  cliBusca.setCep(cli.getCep());
		  cliBusca.setLogradouro(cli.getLogradouro());
		  cliBusca.setEstado(cli.getEstado());
		  cliBusca.setMunicipio(cli.getMunicipio());
		  cliBusca.setPais(cli.getPais());
		 Cliente atualizado =  icliRepo.save(cliBusca);
		  
		  return atualizado;	  		  
	  }
	  
	  
	  public Cliente IncluirCliente(Cliente cliente) 
	  {
		  
		  icliRepo.save(cliente);
		  return icliRepo.findOneBycpf(cliente.getCpf());  
		  
	  }
}
