package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/curso/nome/{nomeCurso}")
    public ResponseEntity<?> findAllProfessorByCurso(
            @PathVariable("nomeCurso") String nomeCurso
    ) {
        return ResponseEntity.ok().body(this.professorService.findAllProfessorByCurso(nomeCurso));
    }

    @GetMapping("/curso/sigla/{siglaCurso}")
    public ResponseEntity<?> findAllProfessorBySiglaCurso(
            @PathVariable("siglaCurso") String siglaCurso
    ) {
        return ResponseEntity.ok().body(this.professorService.findAllProfessorBySiglaCurso(siglaCurso));
    }

    @GetMapping("/turma/semestre/{semestreTurma}")
    public ResponseEntity<?> findAllProfessorBySemestreTurma(
            @PathVariable("semestreTurma") Integer semestreTurma
    ) {
        return ResponseEntity.ok().body(this.professorService.findAllProfessorBySemestreTurma(semestreTurma));
    }

    @GetMapping("/turma/ano/{anoTurma}")
    public ResponseEntity<?> findAllProfessorByAnoTurma(
            @PathVariable("anoTurma") Integer anoTurma
    ) {
        return ResponseEntity.ok().body(this.professorService.findAllProfessorByAnoTurma(anoTurma));
    }

    @GetMapping("/cursoAndTurma/{nomeCurso}/{anoTurma}")
    public ResponseEntity<?> findAllProfessorByCursoAndTurma(
            @PathVariable("nomeCurso") String nomeCurso,
            @PathVariable("anoTurma") Integer anoTurma
    ) {
        return ResponseEntity.ok().body(this.professorService.findAllProfessorByCursoAndTurma(nomeCurso, anoTurma));
    }
}