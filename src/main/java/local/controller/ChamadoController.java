package local.controller;

import local.model.Chamado;
import local.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoDAO;

    @GetMapping
    public List<Chamado> listar(){
        return chamadoDAO.findAll();
    }

    @PostMapping
    public ResponseEntity<Chamado> salvar(@RequestBody Chamado chamado, HttpServletResponse response){

        Chamado ch = chamadoDAO.save(chamado);

        return new ResponseEntity<Chamado>(ch, HttpStatus.CREATED);

    }

    @GetMapping("/buscar/{id}")
    public Chamado buscar(@PathVariable int id){
        return chamadoDAO.findById(id).get();
    }

    @PutMapping("/editar/{id}")
    public Chamado editar(@PathVariable(value = "id") int chId, @Valid @RequestBody Chamado chs){

        Chamado ch = chamadoDAO.findById(chId).get();
            ch.setTitulo(chs.getTitulo());
            ch.setDescricao(chs.getDescricao());
            ch.setStatus(chs.getStatus());
            ch.setTipo(chs.getTipo());
            ch.setEmail(chs.getEmail());
            ch.setEmail2(chs.getEmail2());
            ch.setEmail3(chs.getEmail3());
            ch.setTelefone(chs.getTelefone());
            ch.setTelefone2(chs.getTelefone2());

            Chamado editarChamado = chamadoDAO.save(ch);
            return editarChamado;

    }

    @DeleteMapping("/remover/{id}")
    public void remover(@PathVariable int id){
        Chamado ch = chamadoDAO.findById(id).get();
        chamadoDAO.delete(ch);
    }

}
