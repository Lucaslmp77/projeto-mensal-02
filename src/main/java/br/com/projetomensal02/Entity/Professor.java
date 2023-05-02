package br.com.projetomensal02.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_professor", schema = "projeto-mensal-02")
public class Professor extends AbstractEntity {

    public Professor(String nome, String endereco, String especialidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.especialidade = especialidade;
    }

    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;

    @Column(name = "especialidade", length = 30, nullable = false)
    private String especialidade;

    @ManyToMany(mappedBy = "professor")
    private List<Turma> turma;

    public void setNome(String nome) {
        if (nome == null) {
            throw new RuntimeException("O nome do professor inserido é nulo");
        } else if (nome.isEmpty()) {
            throw new RuntimeException("O nome do professor inserido está vazio");
        } else if (nome.trim().length() < 3) {
            throw new RuntimeException("O nome do professor inserido é muito curto");
        } else if (nome.trim().length() > 25) {
            throw new RuntimeException("O nome do professor inserido ultrapassa o limite máximo");
        } else {
            this.nome = nome;
        }
    }

    public void setEndereco(String endereco) {
        if (endereco == null) {
            throw new RuntimeException("O endereço do professor inserido é nulo");
        } else if (endereco.isEmpty()) {
            throw new RuntimeException("O endereço do professor inserido está vazio");
        } else if (endereco.trim().length() < 3) {
            throw new RuntimeException("O endereço do professor é muito curto");
        } else if (endereco.trim().length() > 50) {
            throw new RuntimeException("O endereço do professor ultrapassa o limite máximo");
        } else {
            this.endereco = endereco;
        }
    }

    public void setEspecialidade(String especialidade) {
        if (especialidade == null) {
            throw new RuntimeException("A especialidade do professor inserida é nula");
        } else if (especialidade.isEmpty()) {
            throw new RuntimeException("A especialidade do professor inserida está vazio");
        } else if (especialidade.trim().length() < 3) {
            throw new RuntimeException("A especialidade do professor é muito curta");
        } else if (especialidade.trim().length() > 30) {
            throw new RuntimeException("A especialidade do professor ultrapassa o limite máximo");
        } else {
            this.especialidade = especialidade;
        }
    }

}
