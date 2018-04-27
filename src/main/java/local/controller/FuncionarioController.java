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
	
	@GetMapping("/buscar/{id}")
	public Funcionario buscar(@PathVariable int id) {
		return funcionarioDAO.findById(id).get();
	}
	
	@PutMapping("/editar/{id}")
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
	
	
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable int id) {
		Funcionario fu = funcionarioDAO.findById(id).get();
		funcionarioDAO.delete(fu);
	}
	
	@PostConstruct
	public void seed() {	
		Funcionario fu1 = new Funcionario();
			fu1.setNome("Thaua Borges");
			fu1.setEmail("thaua97@gmail.com");
			fu1.setCpf("042.777.610-46");
			fu1.setEndereco("Rua alameda sete, n°7, bloco 7");		
		Funcionario fu2 = new Funcionario();	
			fu2.setNome("Lucas Edvald");
			fu2.setEmail("ludivald399@gmail.com");
			fu2.setCpf("023.520.860-43");
			fu2.setEndereco("Rua Visconde da Graça");
			
			funcionarioDAO.saveAll(Arrays.asList(fu1,fu2));
	}
	
}
