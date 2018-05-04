package local.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.model.Funcionario;
import local.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioDAO;
	
	@GetMapping
	public List<Funcionario> listar(){
		return funcionarioDAO.findAll();	
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario, HttpServletResponse response){
		
		Funcionario fu = funcionarioDAO.save(funcionario);
		
		return new ResponseEntity<Funcionario>(fu, HttpStatus.CREATED);
	
	}
	
	@GetMapping("/{id}")
	public Funcionario buscar(@PathVariable int id) {
		return funcionarioDAO.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public Funcionario Editar (@PathVariable(value = "id") int fuId, 
							   @Valid @RequestBody Funcionario func) {
		
	Funcionario fu = funcionarioDAO.findById(fuId).get();	
		fu.setNome(func.getNome());
		fu.setEmail(func.getEmail());
		fu.setCpf(func.getCpf());
		fu.setEndereco(func.getEndereco());
		
		Funcionario editarFuncionario = funcionarioDAO.save(fu);
		return editarFuncionario;
	}
	
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable int id) {
		Funcionario fu = funcionarioDAO.findById(id).get();
		funcionarioDAO.delete(fu);
	}

}
