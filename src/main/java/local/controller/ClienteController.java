package local.controller;

import local.model.Cliente;
import local.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteDAO;

    @GetMapping
    public List<Cliente> listar(){
        return clienteDAO.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente, HttpServletResponse response){
        Cliente cl = clienteDAO.save(cliente);

        return new ResponseEntity<Cliente>(cl, HttpStatus.CREATED);
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscar(@PathVariable int id){
        return clienteDAO.findById(id).get();
    }

    @PutMapping("/editar/{id}")
    public Cliente editar(@PathVariable(value = "id") int clId, @Valid @RequestBody Cliente cli){

        Cliente cl = clienteDAO.findById(clId).get();
                cl.setNome(cli.getNome());
                cl.setEmail(cli.getEmail());
                cl.setCpf(cli.getCpf());
                cl.setEndereco(cli.getEndereco());

        Cliente editarCliente = clienteDAO.save(cl);
        return editarCliente;
    }

    @DeleteMapping("/remover/{id}")
    public void remover(@PathVariable int id){
      Cliente cl = clienteDAO.findById(id).get();
                   clienteDAO.delete(cl);
    }
}
