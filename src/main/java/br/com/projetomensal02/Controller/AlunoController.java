package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

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

    @GetMapping
    public ResponseEntity<List<Aluno>> listAll(

    ) {
        return ResponseEntity.ok().body(this.alunoService.listAll());
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<Aluno> findById(
            @PathVariable("idAluno") Long idAluno
    ) {
        return ResponseEntity.ok().body(this.alunoService.findById(idAluno));
    }

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

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findAlunoByNome(
            @PathVariable("nome") String nome
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAlunoByNome(nome));
    }

    @GetMapping("/curso/nome/{nomeCurso}")
    public ResponseEntity<?> findAllAlunoByCurso(
            @PathVariable("nomeCurso") String nomeCurso
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAllAlunoByCurso(nomeCurso));
    }

    @GetMapping("/curso/sigla/{siglaCurso}")
    public ResponseEntity<?> findAllAlunoBySiglaCurso(
            @PathVariable("siglaCurso") String siglaCurso
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAllAlunoBySiglaCurso(siglaCurso));
    }

    @GetMapping("/turma/semestre/{semestreTurma}")
    public ResponseEntity<?> findAllAlunoBySemestreTurma(
            @PathVariable("semestreTurma") Integer semestreTurma
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAllAlunoBySemestreTurma(semestreTurma));
    }

    @GetMapping("/turma/ano/{anoTurma}")
    public ResponseEntity<?> findAllAlunoByAnoTurma(
            @PathVariable("anoTurma") Integer anoTurma
    ) {
        return ResponseEntity.ok().body(this.alunoService.findAllAlunoByAnoTurma(anoTurma));
    }

//    @GetMapping("/cursoAndTurma/{nomeCurso}/{anoTurma}")
//    public ResponseEntity<?> findAllAlunoByCursoAndTurma(
//            @PathVariable("nomeCurso") String nomeCurso,
//            @PathVariable("anoTurma") Integer anoTurma
//    ) {
//        return ResponseEntity.ok().body(this.alunoService.findAllAlunoByCursoAndTurma(nomeCurso, anoTurma));
//    }

}
