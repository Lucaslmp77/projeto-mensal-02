package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Professor professor
    ){
        try{
            this.professorService.save(professor);
            return ResponseEntity.ok().body("Professor cadastrado!");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idProfessor}")
    public ResponseEntity<?> update(
            @PathVariable Long idProfessor,
            @RequestBody Professor professor
    ){
        try{
            this.professorService.update(idProfessor, professor);
            return ResponseEntity.ok().body("Professor atualizado com sucesso!");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listAll(

    ){
        return ResponseEntity.ok().body(this.professorService.listAll());
    }



    @GetMapping("/turma/{idTurma}")
    public ResponseEntity<List<Professor>> findProfessoresByIdTurma(
            @PathVariable("idTurma") Long idTurma
    ){
        return ResponseEntity.ok().body(this.professorService.findProfessoresByIdTurma(idTurma));
    }

    @GetMapping("/nome/{nomeProfessor}")
    public ResponseEntity<List<Professor>> findProfessoresByNome(
            @PathVariable("nomeProfessor") String nomeProfessor
    ){
        return ResponseEntity.ok().body(this.professorService.findProfessoresByNome(nomeProfessor));
    }

    @GetMapping("/especialidade/{nomeEspecialidade}")
    public ResponseEntity<List<Professor>> findProfessoresByEspecialidade(
            @PathVariable("nomeEspecialidade") String nomeEspecialidade
    ){
        return ResponseEntity.ok().body(this.professorService.findProfessoresByEspecialidade(nomeEspecialidade));
    }

    @GetMapping("/{idProfessor}")
    public ResponseEntity<Professor> findById(
            @PathVariable("idProfessor") Long idProfessor
    ){
        return ResponseEntity.ok().body(this.professorService.findById(idProfessor));
    }

    @DeleteMapping("/delete/{idProfessor}")
    public ResponseEntity<?> delete(
            @PathVariable Long idProfessor,
            @RequestBody Professor professor
    ){
        try{
            this.professorService.delete(idProfessor,professor);
            return ResponseEntity.ok().body("Professor deletado com sucesso!");
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
