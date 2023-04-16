package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Curso;
import br.com.projetomensal02.Repository.CursoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso save(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    public List<Curso> listAll() {
        return this.cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return this.cursoRepository.findById(id).orElse(new Curso());
    }

    @Transactional
    public void update(Long id, Curso curso) {
        if(id == curso.getId()) {
            this.cursoRepository.save(curso);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Curso curso) {
        if(id == curso.getId()) {
            this.cursoRepository.delete(curso);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Curso> findCursoBySigla(String sigla) {
        return this.cursoRepository.findCursoBySigla(sigla);
    }

    public List<Curso> findCursoByNome(String nome) {
        return this.cursoRepository.findCursoByNome(nome);
    }
}
