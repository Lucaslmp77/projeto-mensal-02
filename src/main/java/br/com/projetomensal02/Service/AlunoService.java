package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Aluno;
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

}
