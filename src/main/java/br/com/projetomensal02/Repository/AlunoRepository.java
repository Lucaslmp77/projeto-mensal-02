package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("FROM Aluno aluno WHERE aluno.curso.nome = :nomeCurso")
    public List<Aluno> findAlunoByNomeCurso(@Param("nomeCurso") String nomeCurso);

    @Query("FROM Aluno aluno WHERE aluno.turma.id = :idTurma")
    public List<Aluno> findAlunoByIdTurma(@Param("idTurma") Long idTurma);

    @Query("FROM Aluno aluno WHERE aluno.nome = :nomeAluno")
    public List<Aluno> findAlunoByNome(@Param("nomeAluno") String nomeAluno);
}
