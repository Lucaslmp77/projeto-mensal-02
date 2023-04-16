package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_aluno", schema = "projeto-mensal-02")
public class Aluno extends AbstractEntity {
    @Getter @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "idade", length = 25, nullable = false)
    private Integer idade;

    @Getter @Setter
    @Column(name = "endereco", length = 30, nullable = false)
    private String endereco;
}
