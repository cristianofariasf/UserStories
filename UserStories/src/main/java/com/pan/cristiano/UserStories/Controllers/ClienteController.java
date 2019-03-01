package com.pan.cristiano.UserStories.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pan.cristiano.UserStories.Models.Cliente;
import com.pan.cristiano.UserStories.Models.ClienteViewModel;
import com.pan.cristiano.UserStories.Service.ClienteService;

@RestController("cliente")
public class ClienteController {

	@Autowired
	ClienteService cli;

	@RequestMapping(value = "cliente/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> Get(@PathVariable("cpf") String cpf) {
		try {
			Cliente clienteCPF = cli.ListarPorCPF(cpf);
			return new ResponseEntity<Cliente>(clienteCPF, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public ResponseEntity<Cliente> Post(@RequestBody Cliente cliente) {
		try {
			Cliente clienteSalvo = cli.IncluirCliente(cliente);
			return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@RequestMapping(value = "cliente", method = RequestMethod.PUT)
	public ResponseEntity<String> Put(@RequestBody ClienteViewModel clienteEndereco) {
		try {
			cli.AtualizarCLiente(clienteEndereco);
			return new ResponseEntity<String>("sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
