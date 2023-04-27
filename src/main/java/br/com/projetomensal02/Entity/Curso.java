package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tb_curso", schema = "projeto-mensal-02")
public class Curso extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "sigla", length = 10, nullable = false)
    private String sigla;
}
