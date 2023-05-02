package br.com.projetomensal02;

import br.com.projetomensal02.Entity.Turma;
import org.junit.jupiter.api.*;
import br.com.projetomensal02.Entity.Aluno;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.Optional;

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

    //Testes de integração

    @Test
    @DisplayName("Deve haver apenas 3 turmas em aluno")
    public void adicionarTurmasEmAlunos() {

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        Assertions.assertEquals(3, aluno.getTurma().size(), "Deve haver 3 turmas em aluno");
    }

    @Test
    @DisplayName("Deve remover apenas 1 turma em aluno")
    public void remover1TurmasEmAluno(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        boolean removido = aluno.getTurma().remove(turma1);

        Assertions.assertTrue(removido, "Deve remover a 'turma1' com sucesso");
        Assertions.assertEquals(2, aluno.getTurma().size(),"Deve retornar 2 turmas no professor");
    }

    @Test
    @DisplayName("Deve remover apenas 3 turma em aluno")
    public void remover3TurmasEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        boolean removido1 = aluno.getTurma().remove(turma1);
        boolean removido12 = aluno.getTurma().remove(turma12);
        boolean removido123 = aluno.getTurma().remove(turma123);


        Assertions.assertTrue(removido1, "Deve remover a 'turma1' com sucesso");
        Assertions.assertTrue(removido12, "Deve remover a 'turma12' com sucesso");
        Assertions.assertTrue(removido123, "Deve remover a 'turma123' com sucesso");

        Assertions.assertEquals(0, aluno.getTurma().size(),"Deve retornar 0 turmas no professor");
    }

    @Test
    @DisplayName("Deve retornar a turma buscada em aluno")
    public void buscarTurmaPorSemestreEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        Optional<Turma> turmaEncontrada = aluno.getTurma().stream().filter(turma -> turma.getSemestre().equals(1)).findFirst();

        Assertions.assertTrue(turmaEncontrada.isPresent(),"Deve encontrar o Semestre 1");
    }

    @Test
    @DisplayName("Buscar Turma Por Ano Em aluno")
    public void buscarTurmaPorAnoEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        Optional<Turma> turmaEncontrada = aluno.getTurma().stream().filter(turma -> turma.getAno().equals(2020)).findFirst();

        Assertions.assertTrue(turmaEncontrada.isPresent(),"Deve encontrar o Ano 2020");
    }

    @Test
    @DisplayName("Deve retornar o Ano especificado em aluno")
    public void retornarAnoEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        aluno.setTurma(turmas);

        Optional<Turma> turmaEncontrada = aluno.getTurma().stream().filter(turma -> turma.getAno().equals(2022)).findFirst();

        Assertions.assertEquals(2022,turmaEncontrada.get().getAno(),"O ano encontrado deve ser 2022");
    }
}
