package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Curso;
import br.com.projetomensal02.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<?> save(
            @RequestBody Curso curso
    ) {
        try {
            this.cursoService.save(curso);
            return ResponseEntity.ok().body("Curso cadastrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listAll(

    ) {
        return ResponseEntity.ok().body(this.cursoService.listAll());
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> findById(
            @PathVariable("idCurso") Long idCurso
    ) {
        return ResponseEntity.ok().body(this.cursoService.findById(idCurso));
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<?> update(
            @PathVariable Long idCurso,
            @RequestBody Curso curso
    ) {
        try {
            this.cursoService.update(idCurso, curso);
            return ResponseEntity.ok().body("Curso atualizado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{idCurso}")
    public ResponseEntity<?> delete(
            @PathVariable Long idCurso,
            @RequestBody Curso curso
    ) {
        try {
            this.cursoService.delete(idCurso, curso);
            return ResponseEntity.ok().body("Curso deletada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/sigla/{sigla}")
    public ResponseEntity<?> findCursoBySigla(
            @PathVariable("sigla") String sigla
    ) {
        return ResponseEntity.ok().body(this.cursoService.findCursoBySigla(sigla));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findCursoByNome(
            @PathVariable("nome") String nome
    ) {
        return ResponseEntity.ok().body(this.cursoService.findCursoByNome(nome));
    }
}
