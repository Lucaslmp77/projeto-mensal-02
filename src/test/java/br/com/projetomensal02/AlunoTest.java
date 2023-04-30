package br.com.projetomensal02;

import org.junit.jupiter.api.*;
import br.com.projetomensal02.Entity.Aluno;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.BeforeAll;

public class AlunoTest {

    private static Aluno aluno;

    private static String nome;
    private static Integer idade;
    private static String endereco;

    @BeforeAll
    public static void definirValoresPadrao() {

        nome = "Rodrigo";
        endereco = "Rua Dos Cravos";
        idade = 18;
    }

    @BeforeEach
    public void inicializarAluno() {

        aluno = new Aluno(nome, idade, endereco);
    }
    //Nome
    @Test
    @DisplayName("Deve retornar o nome do aluno")
    public void deveRetornarONomeDoAluno() {

        Assertions.assertEquals(nome, aluno.getNome());
    }
    @Test
    @DisplayName("Não deve retornar o nome do aluno sendo nulo")
    public void naoDeveRetornarNomeDoAlunoNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setNome(null));
    }
    @Test
    @DisplayName("Não deve retornar o nome do aluno sendo vazio")
    public void naoDeveRetornarNomeDoAlunoVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setNome(""));
    }
    @Test
    @DisplayName("Não deve retornar o nome do aluno tendo menos de 3 letras")
    public void naoDeveRetornarNomeDoAlunoMenorQue3Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setNome("RF"));
    }
    @Test
    @DisplayName("Não deve retornar o nome do aluno tendo mais de 25 letras")
    public void naoDeveRetornarNomeDoAlunoMaiorQue25Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setNome("Rodrigo Ferreira Lópes Valerio Da Silva"));
    }
    //Idade
    @Test
    @DisplayName("Retornar idade do aluno")
    public void deveRetornarIdadeDoAluno(){

        Assertions.assertEquals(idade, aluno.getIdade());
    }
    @Test
    @DisplayName("Nao deve retornar a idade do aluno sendo nula")
    public void naoRetornarIdadeDoAlunoNulo(){

        Assertions.assertThrows(RuntimeException.class, ()-> aluno.setIdade(null));
    }
    @Test
    @DisplayName("Não deve retornar a idade Do Aluno estando acima do limite")
    public void naoRetornarIdadeDoAlunoAcimaDoLimite(){

        Assertions.assertThrows(RuntimeException.class, ()-> aluno.setIdade(125));
    }
    @Test
    @DisplayName("Não deve retornar a idade do Aluno estando abaixo do limite")
    public void naoRetornarIdadeDoAlunoAbaixoDoLimite() {

        Assertions.assertThrows(RuntimeException.class, () ->aluno.setIdade(-15));
    }
    //Endereço
    @Test
    @DisplayName("deve retornar o endereço do aluno")
    public void DeveRetornarEnderecoDoAluno() {

        Assertions.assertEquals(endereco, aluno.getEndereco());
    }
    @Test
    @DisplayName("Não deve retornar o endereço do aluno sendo nulo")
    public void NaoRetornarEnderecoDoAlunoNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setEndereco(null));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do aluno sendo vazio")
    public void NaoRetornarEnderecoDoAlunoVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setEndereco(""));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do aluno tendo menos de 3 letras")
    public void NaoRetornarEnderecoDoAlunoMenorQue3Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setEndereco("am"));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do aluno tendo mais de 50 letras")
    public void NaoRetornarEnderecoDoAlunoMaiorQue50Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> aluno.setEndereco("rua das oliveiras perdidas pelos campos do seu chris"));
    }
}
