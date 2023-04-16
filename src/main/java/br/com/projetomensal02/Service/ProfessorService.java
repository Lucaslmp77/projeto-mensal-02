package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listAll(){ return this.professorRepository.findAll(); }

    public List<Professor> findProfessoresByNomeCurso(String nomeCurso){ return this.professorRepository.findProfessoresByNomeCurso(nomeCurso); }

    public List<Professor> findProfessoresByIdTurma(Long idTurma){ return this.professorRepository.findProfessoresByIdTurma(idTurma); }

    public List<Professor> findProfessoresByNome(String nomeProfessor){ return this.professorRepository.findProfessoresByNome(nomeProfessor); }

    public List<Professor> findProfessoresByEspecialidade(String nomeEspecialidade){ return this.professorRepository.findProfessoresByEspecialidade(nomeEspecialidade); }

    public Professor findById(Long id) { return this.professorRepository.findById(id).orElse(new Professor());}

    @Transactional
    public Professor save(Professor professor){ return this.professorRepository.save(professor); }

    @Transactional
    public void update(Long id, Professor professor){
        if (id==professor.getId()){
            this.professorRepository.save(professor);
        }else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void remove(Long id, Professor professor){
        if (id==professor.getId()){
            this.professorRepository.delete(professor);
        } else {
            throw new RuntimeException();
        }
    }

}
