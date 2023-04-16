package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Curso;
import br.com.projetomensal02.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    //Método de cadastrar cursos
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

    //Método de listar cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listAll(

    ) {
        return ResponseEntity.ok().body(this.cursoService.listAll());
    }

    //Método de buscar cursos por id

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> findById(
            @PathVariable("idCurso") Long idCurso
    ) {
        return ResponseEntity.ok().body(this.cursoService.findById(idCurso));
    }

    //Método de atualizar informações da curso
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

    //Método de deletar cursos
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

    //Método de buscar curso por semestre
    @GetMapping("/sigla/{sigla}")
    public ResponseEntity<?> findCursoBySigla(
            @PathVariable("sigla") String sigla
    ) {
        return ResponseEntity.ok().body(this.cursoService.findCursoBySigla(sigla));
    }

    //Método de buscar curso por ano
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> findCursoByNome(
            @PathVariable("nome") String nome
    ) {
        return ResponseEntity.ok().body(this.cursoService.findCursoByNome(nome));
    }
}
