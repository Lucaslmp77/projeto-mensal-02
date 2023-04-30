package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno save(Aluno aluno) {
        return this.alunoRepository.save(aluno);
    }

    public List<Aluno> listAll() {
        return this.alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return this.alunoRepository.findById(id).orElse(new Aluno());
    }

    @Transactional
    public void update(Long id, Aluno aluno) {
        if(id == aluno.getId()) {
            this.alunoRepository.save(aluno);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void delete(Long id, Aluno aluno) {
        if(id == aluno.getId()) {
            this.alunoRepository.delete(aluno);
        } else {
            throw new RuntimeException();
        }
    }
    public List<Aluno> findAlunoByNome(String nomeAluno) {
        return this.alunoRepository.findAlunoByNome(nomeAluno);
    }

    public List<Aluno> findAllAlunoByCurso(String nomeCurso) {
        return this.alunoRepository.findAllAlunoByCurso(nomeCurso);
    }

//    public List<Aluno> findAllAlunoBySiglaCurso(String siglaCurso) {
//        return this.alunoRepository.findAllAlunoBySiglaCurso(siglaCurso);
//    }
//
//    public List<Aluno> findAllAlunoBySemestreTurma(Integer semestreTurma) {
//        return this.alunoRepository.findAllAlunoBySemestreTurma(semestreTurma);
//    }
//
//    public List<Aluno> findAllAlunoByAnoTurma(Integer anoTurma) {
//        return this.alunoRepository.findAllAlunoByAnoTurma(anoTurma);
//    }
//
//    public List<Aluno> findAllAlunoByCursoAndTurma(String nomeCurso, Integer anoTurma) {
//        return this.alunoRepository.findAllAlunoByCursoAndTurma(nomeCurso, anoTurma);
//    }
}