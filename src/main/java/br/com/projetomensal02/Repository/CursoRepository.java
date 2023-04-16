package br.com.projetomensal02.Repository;

import br.com.projetomensal02.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("FROM Curso curso WHERE curso.sigla = :sigla")
    public List<Curso> findCursoBySigla(@Param("sigla") String sigla);

    @Query("FROM Curso curso WHERE curso.nome = :nome")
    public List<Curso> findCursoByNome(@Param("nome") String nome);
}
