package br.com.projetomensal02.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_aluno", schema = "projeto-mensal-02")
public class Aluno extends AbstractEntity {

    public Aluno(String nome, Integer idade, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    @Column(name = "nome", length = 25, nullable = false)
    private String nome;

    @Column(name = "idade", length = 25, nullable = false)
    private Integer idade;

    @Column(name = "endereco", length = 30, nullable = false)
    private String endereco;

    @ManyToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Turma> turma;

    public void setNome(String nome) {
        if(nome == null) {
            throw new RuntimeException("O nome do aluno inserido é nulo");
        } else if (nome.isEmpty()) {
            throw new RuntimeException("O nome do aluno inserido está vazio");
        } else if (nome.trim().length() < 3) {
            throw new RuntimeException("O nome do aluno inserido é muito curto");
        } else if (nome.trim().length() > 25) {
            throw new RuntimeException("O nome do aluno inserido ultrapassa o limite máximo");
        } else if (nome.matches("[0-9]+")) {
            throw new RuntimeException("O nome do aluno inserido é composto por números");
        }
        else {
            this.nome = nome;
        }
    }
    public void setEndereco(String endereco) {
        if (endereco == null) {
            throw new RuntimeException("O endereço do aluno inserido é nulo");
        } else if (endereco.isEmpty()) {
            throw new RuntimeException("O endereço do aluno inserido está vazio");
        } else if (endereco.trim().length() < 3) {
            throw new RuntimeException("O endereço do aluno é muito curto");
        } else if (endereco.trim().length() > 50) {
            throw new RuntimeException("O endereço do aluno ultrapassa o limite máximo");
        } else {
            this.endereco = endereco;
        }
    }
    public void setIdade(Integer idade) {
        if(idade == null){
            throw new RuntimeException("A idade do aluno inserido é nula");
        } else if(idade > 120){
            throw new RuntimeException("A idade do aluno inserido está acima do limite");
        } else if (idade < 0){
            throw new RuntimeException("A idade do aluno inserido é menor que o limite permitido");
        } else {
            this.idade = idade;
        }
    }
}