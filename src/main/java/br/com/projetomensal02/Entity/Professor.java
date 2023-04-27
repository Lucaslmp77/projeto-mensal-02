package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_professor", schema = "projeto-mensal-02")
public class Professor extends AbstractEntity {
    @Getter
    @Setter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "endereco", length = 30, nullable = false)
    private String endereco;

    @Getter
    @Setter
    @Column(name = "especialidade", length = 30, nullable = false)
    private String especialidade;


}
