package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    //Método de cadastrar alunos
    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Aluno aluno
    ) {
        try {
            this.alunoService.save(aluno);
            return ResponseEntity.ok().body("Aluno cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Método de listar alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> listAll(

    ) {
        return ResponseEntity.ok().body(this.alunoService.listAll());
    }

    //Método de buscar alunos por id

    @GetMapping("/{idAluno}")
    public ResponseEntity<Aluno> findById(
            @PathVariable("idAluno") Long idAluno
    ) {
        return ResponseEntity.ok().body(this.alunoService.findById(idAluno));
    }

    //Método de atualizar informações da aluno
    @PutMapping("/{idAluno}")
    public ResponseEntity<?> update(
            @PathVariable Long idAluno,
            @RequestBody Aluno aluno
    ) {
        try {
            this.alunoService.update(idAluno, aluno);
            return ResponseEntity.ok().body("Aluno atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Método de deletar alunos
    @DeleteMapping("/delete/{idAluno}")
    public ResponseEntity<?> delete(
            @PathVariable Long idAluno,
            @RequestBody Aluno aluno
    ) {
        try {
            this.alunoService.delete(idAluno, aluno);
            return ResponseEntity.ok().body("Aluno deletada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Método de buscar aluno por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findAlunoByNome(
            @PathVariable("nome") String nome
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAlunoByNome(nome));
    }
}
