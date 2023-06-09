package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("FROM Professor professor WHERE professor.nome = :nomeProfessor")
    public List<Professor> findProfessoresByNome(@Param("nomeProfessor") String nomeProfessor);

    @Query("FROM Professor professor WHERE professor.especialidade = :nomeEspecialidade")
    public List<Professor> findProfessoresByEspecialidade(@Param("nomeEspecialidade") String nomeEspecialidade);

    @Query("SELECT professor FROM Professor professor INNER JOIN professor.turma prof WHERE prof.curso.nome = :nomeCurso")
    public List<Professor> findAllProfessorByCurso(@Param("nomeCurso")String nomeCurso);

    @Query("SELECT professor FROM Professor professor INNER JOIN professor.turma prof WHERE prof.curso.sigla = :siglaCurso")
    public List<Professor> findAllProfessorBySiglaCurso(@Param("siglaCurso")String siglaCurso);

    @Query("SELECT professor FROM Professor professor INNER JOIN professor.turma prof WHERE prof.semestre = :semestreTurma")
    public List<Professor> findAllProfessorBySemestreTurma(@Param("semestreTurma")Integer semestreTurma);

    @Query("SELECT professor FROM Professor professor INNER JOIN professor.turma prof WHERE prof.ano = :anoTurma")
    public List<Professor> findAllProfessorByAnoTurma(@Param("anoTurma")Integer anoTurma);

    @Query("SELECT professor FROM Professor professor INNER JOIN professor.turma prof WHERE prof.curso.nome = :nomeCurso" +
            " AND prof.ano = :anoTurma")
    public List<Professor> findAllProfessorByCursoAndTurma(String nomeCurso, Integer anoTurma);
}
