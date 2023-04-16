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

    //Método de desativar turma
    @DeleteMapping("/disable/{idTurma}")
    public ResponseEntity<?> disable(
            @PathVariable Long idTurma
    ) {
        try {
            this.turmaService.delete(idTurma);
            return ResponseEntity.ok().body("Turma desativada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/semestre/{idSemestre}")
    public ResponseEntity<?> findTurmaBySemestre(
            @PathVariable("idSemestre") Long idSemestre
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaBySemestre(idSemestre));
    }

    @GetMapping("/ano/{idAno}")
    public ResponseEntity<?> findTurmaByAno(
            @PathVariable("idAno") Long idAno
    ) {
        return ResponseEntity.ok().body(this.turmaService.findTurmaByAno(idAno));
    }
}