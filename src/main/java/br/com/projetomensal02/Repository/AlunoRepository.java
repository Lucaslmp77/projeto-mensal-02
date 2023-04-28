package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("FROM Aluno aluno WHERE aluno.nome = :nomeAluno")
    public List<Aluno> findAlunoByNome(@Param("nomeAluno") String nomeAluno);

    @Query("SELECT aluno FROM Aluno aluno INNER JOIN Turma turma ON (turma.aluno.id = aluno.id)" +
            "WHERE turma.curso.nome = :nomeCurso")
    public List<Aluno> findAllAlunoByCurso(@Param("nomeCurso")String nomeCurso);

    @Query("SELECT aluno FROM Aluno aluno INNER JOIN Turma turma ON (turma.aluno.id = aluno.id)" +
            "WHERE turma.curso.sigla = :siglaCurso")
    public List<Aluno> findAllAlunoBySiglaCurso(@Param("siglaCurso")String siglaCurso);

    @Query("SELECT aluno FROM Aluno aluno INNER JOIN Turma turma ON (turma.aluno.id = aluno.id)" +
            "WHERE turma.semestre = :semestreTurma")
    public List<Aluno> findAllAlunoBySemestreTurma(@Param("semestreTurma")Integer semestreTurma);

    @Query("SELECT aluno FROM Aluno aluno INNER JOIN Turma turma ON (turma.aluno.id = aluno.id)" +
            "WHERE turma.ano = :anoTurma")
    public List<Aluno> findAllAlunoByAnoTurma(@Param("anoTurma")Integer anoTurma);

    @Query("SELECT aluno FROM Aluno aluno INNER JOIN Turma turma ON (turma.aluno.id = aluno.id)" +
            "WHERE turma.curso.nome = :nomeCurso AND turma.ano = :anoTurma")
    public List<Aluno> findAllAlunoByCursoAndTurma(String nomeCurso, Integer anoTurma);
}
