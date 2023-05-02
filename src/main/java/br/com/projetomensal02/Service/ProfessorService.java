package br.com.projetomensal02.Service;

import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Repository.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listAll(){ return this.professorRepository.findAll(); }

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
    public void delete(Long id){
        var professor = this.professorRepository.findById(id);
        if (id == professor.get().getId()){
            this.professorRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Professor> findProfessoresByNome(String nomeProfessor){
        return this.professorRepository.findProfessoresByNome(nomeProfessor);
    }

    public List<Professor> findProfessoresByEspecialidade(String nomeEspecialidade){
        return this.professorRepository.findProfessoresByEspecialidade(nomeEspecialidade);
    }

    public List<Professor> findAllProfessorByCurso(String nomeCurso) {
        return this.professorRepository.findAllProfessorByCurso(nomeCurso);
    }

    public List<Professor> findAllProfessorBySiglaCurso(String siglaCurso) {
        return this.professorRepository.findAllProfessorBySiglaCurso(siglaCurso);
    }

    public List<Professor> findAllProfessorBySemestreTurma(Integer semestreTurma) {
        return this.professorRepository.findAllProfessorBySemestreTurma(semestreTurma);
    }

    public List<Professor> findAllProfessorByAnoTurma(Integer anoTurma) {
        return this.professorRepository.findAllProfessorByAnoTurma(anoTurma);
    }

    public List<Professor> findAllProfessorByCursoAndTurma(String nomeCurso, Integer anoTurma) {
        return this.professorRepository.findAllProfessorByCursoAndTurma(nomeCurso, anoTurma);
    }
}