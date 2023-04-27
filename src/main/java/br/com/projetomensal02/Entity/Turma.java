package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_turma", schema = "projeto-mensal-02")
public class Turma extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "semestre", length = 10, nullable = false)
    private Integer semestre;

    @Getter @Setter
    @Column(name = "ano", length = 10, nullable = false)
    private Integer ano;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    @JoinColumn(name="id_aluno")
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    @JoinColumn(name="id_professor")
    private Professor professor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Getter
    @Setter
    @JoinColumn(name="id_curso")
    private Curso curso;
}
