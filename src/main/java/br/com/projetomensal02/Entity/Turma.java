package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_turma", schema = "projeto-mensal-02")
public class Turma extends AbstractEntity {

    @Getter
    @Column(name = "semestre", length = 10, nullable = false)
    private Integer semestre;

    @Getter
    @Column(name = "ano", length = 10, nullable = false)
    private Integer ano;

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "turma_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "aluno_id", nullable = false))
    private List<Aluno> aluno;

    @ManyToMany
    @Getter
    @Setter
    @JoinTable(
            name = "turma_professor",
            joinColumns = @JoinColumn(name = "turma_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "professor_id", nullable = false))
    private List<Professor> professor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Turma(Integer semestre, Integer ano) {
        this.semestre = semestre;
        this.ano = ano;
    }

    public Turma() {
    }

    public void setSemestre(Integer semestre) {
        if (semestre == null) {
            throw new RuntimeException("O semestre inserido é nulo");
        } else if (semestre <= 0) {
            throw new RuntimeException("O semestre inserido é muito curto");
        } else if (semestre > 10) {
            throw new RuntimeException("O semestre inserido ultrapassa o limite máximo");
        } else {
            this.semestre = semestre;
        }
    }

    public void setAno(Integer ano) {
        if (ano == null) {
            throw new RuntimeException("O ano inserido é nulo");
        } else if (ano <= 0) {
            throw new RuntimeException("O ano inserido é muito curto");
        } else if (ano > 3000) {
            throw new RuntimeException("O ano inserido ultrapassa o limite máximo");
        } else {
            this.ano = ano;
        }
    }
}
