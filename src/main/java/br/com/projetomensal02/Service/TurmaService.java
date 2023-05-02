package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Turma;
import br.com.projetomensal02.Repository.TurmaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listAll(){ return this.turmaRepository.findAll(); }

    public Turma findById(Long id){ return this.turmaRepository.findById(id).orElse(new Turma()); }

    @Transactional
    public Turma save(Turma turma){
        if (turma.getAluno().size() >= 1 && turma.getProfessor().size() >= 1) {
            return this.turmaRepository.save(turma);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void update(Long id, Turma turma){
        if (id==turma.getId()){
            this.turmaRepository.save(turma);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id){
        var turma = this.turmaRepository.findById(id);
        if (id == turma.get().getId()){
            this.turmaRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Turma> findTurmaBySemestre(Integer semestre){ return this.turmaRepository.findTurmaBySemestre(semestre); }

    public List<Turma> findTurmaByAno(Integer ano){ return this.turmaRepository.findTurmaByAno(ano); }
}