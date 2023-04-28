package br.com.projetomensal02.Entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "tb_curso", schema = "projeto-mensal-02")
public class Curso extends AbstractEntity {

    public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public Curso() {
    }

    @Getter
    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Getter
    @Column(name = "sigla", length = 10, nullable = false)
    private String sigla;

    public void setNome(String nome) {
        if (nome == null) {
            throw new RuntimeException("O nome do curso inserido é nulo");
        } else if (nome.isEmpty()) {
            throw new RuntimeException("O nome do curso inserido está vazio");
        } else if (nome.trim().length() < 3) {
            throw new RuntimeException("O nome do curso inserido é muito curto");
        } else if (nome.trim().length() > 25) {
            throw new RuntimeException("O nome do curso inserido ultrapassa o limite máximo");
        } {
            this.nome = nome;
        }
    }

    public void setSigla(String sigla) {
        if (sigla == null) {
            throw new RuntimeException("A sigla do curso inserida é nula");
        } else if (sigla.isEmpty()) {
            throw new RuntimeException("A sigla do curso inserida está vazia");
        } else if (sigla.trim().length() > 10) {
            throw new RuntimeException("A sigla do curso inserida tem mais do que 10 letras");
        } else if (sigla.trim().length() < 2) {
            throw new RuntimeException("A sigla do curso inserida deve ter no mínimo 2 letras");
        } else {
            this.sigla = sigla;
        }
    }
}
