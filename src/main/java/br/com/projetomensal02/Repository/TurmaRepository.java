package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query("FROM Turma turma WHERE turma.semestre = :semestre")
    public List<Turma> findTurmaBySemestre(@Param("semestre") Integer semestre);

    @Query("FROM Turma turma WHERE turma.ano = :ano")
    public List<Turma> findTurmaByAno(@Param("ano") Integer ano);
}
