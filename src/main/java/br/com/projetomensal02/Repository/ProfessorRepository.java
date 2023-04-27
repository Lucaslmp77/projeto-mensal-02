package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("FROM Professor professor WHERE professor.turma.id = :idTurma")
    public List<Professor> findProfessoresByIdTurma(@Param("idTurma") Long idTurma);

    @Query("FROM Professor professor WHERE professor.nome = :nomeProfessor")
    public List<Professor> findProfessoresByNome(@Param("nomeProfessor") String nomeProfessor);

    @Query("FROM Professor professor WHERE professor.especialidade = :nomeEspecialidade")
    public List<Professor> findProfessoresByEspecialidade(@Param("nomeEspecialidade") String nomeEspecialidade);
}
