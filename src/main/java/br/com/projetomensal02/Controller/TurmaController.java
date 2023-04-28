package br.com.projetomensal02.Controller;


import br.com.projetomensal02.Entity.Turma;
import br.com.projetomensal02.Service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Turma turma
    ) {
        try {
            this.turmaService.save(turma);
            return ResponseEntity.ok().body("Turma cadastrada!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listAll(

    ) {
        return ResponseEntity.ok().body(this.turmaService.listAll());
    }

    @GetMapping("/{idTurma}")
    public ResponseEntity<Turma> findById(
            @PathVariable("idTurma") Long idTurma
    ) {
        return ResponseEntity.ok().body(this.turmaService.findById(idTurma));
    }

    @GetMapping("/semestre/{idSemestre}")
    public ResponseEntity<?> findTurmaBySemestre(
            @PathVariable("idSemestre") Integer idSemestre
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaBySemestre(idSemestre));
    }

    @GetMapping("/ano/{idAno}")
    public ResponseEntity<?> findTurmaByAno(
            @PathVariable("idAno") Integer idAno
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaByAno(idAno));
    }

    @PutMapping("/{idTurma}")
    public ResponseEntity<?> update(
            @PathVariable Long idTurma,
            @RequestBody Turma turma
    ) {
        try {
            this.turmaService.update(idTurma, turma);
            return ResponseEntity.ok().body("Turma atualizada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idTurma}")
    public ResponseEntity<?> delete(
            @PathVariable Long idTurma,
            @RequestBody Turma turma
    ) {
        try {
            this.turmaService.delete(idTurma, turma);
            return ResponseEntity.ok().body("Turma deletada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}