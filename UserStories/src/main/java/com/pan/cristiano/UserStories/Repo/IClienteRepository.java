package com.pan.cristiano.UserStories.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pan.cristiano.UserStories.Models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long>{

	  Cliente findOneBycpf(String CPF);

	 
}
