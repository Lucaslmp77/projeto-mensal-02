package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Turma;
import br.com.projetomensal02.Service.TurmaService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    //Método de cadastrar turma
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

    //Método de listar turma
    @GetMapping
    public ResponseEntity<List<Turma>> listAll(

    ) {
        return ResponseEntity.ok().body(this.turmaService.listAll());
    }

    //Método de buscar turma por id

    @GetMapping("/{idTurma}")
    public ResponseEntity<Turma> findById(
            @PathVariable("idTurma") Long idTurma
    ) {
        return ResponseEntity.ok().body(this.turmaService.findById(turmaService));
    }

    //Método de atualizar informações da turma
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

    //Método de deletar turma
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

    //Método de buscar turma por semestre
    @GetMapping("/semestre/{idSemestre}")
    public ResponseEntity<?> findTurmaBySemestre(
            @PathVariable("idSemestre") Integer idSemestre
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaBySemestre(idSemestre));
    }

    //Método de buscar turma por ano
    @GetMapping("/ano/{idAno}")
    public ResponseEntity<?> findTurmaByAno(
            @PathVariable("idAno") Integer idAno
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaByAno(idAno));
    }
}