package br.com.projetomensal02;
import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Entity.Turma;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Optional;

public class ProfessorTest {

    private Professor professor;

    private static String nome;
    private static String endereco;
    private static String especialidade;

    @BeforeAll
    public static void definirValoresPadrões() {

        nome = "Valdecir";
        endereco = "Rua arenque";
        especialidade = "Programação";
    }
    @BeforeEach
    public void inicializarProfessor() {

        professor = new Professor(nome, endereco, especialidade);
    }
    //Nome
    @Test
    @DisplayName("Deve retornar o nome do professor")
    public void deveRetornarONomeDoProfessor() {

        Assertions.assertEquals(nome, professor.getNome());
    }
    @Test
    @DisplayName("Não deve retornar o nome do professor sendo nulo")
    public void naoDeveRetornarNomeDoProfessorNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setNome(null));
    }
    @Test
    @DisplayName("Não deve retornar o nome do profesor sendo vazio")
    public void naoDeveRetornarNomeDoProfessorVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setNome(""));
    }
    @Test
    @DisplayName("Não deve retornar o nome do profesor tendo menos de 3 letras")
    public void naoDeveRetornarNomeDoProfessorMenorQue3Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setNome("MA"));
    }
    @Test
    @DisplayName("Não deve retornar o nome do profesor tendo mais de 25 letras")
    public void naoDeveRetornarNomeDoProfessorMaiorQue25Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setNome("Valdomiro Pereira Felipe Dos Santos Domingues"));
    }
    //Endereço
    @Test
    @DisplayName("deve retornar o endereço do profesor")
    public void DeveRetornarEnderecoDoProfessor() {

        Assertions.assertEquals(endereco, professor.getEndereco());
    }
    @Test
    @DisplayName("Não deve retornar o endereço do professor sendo nulo")
    public void NaoRetornarEnderecoDoProfessorNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEndereco(null));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do professor sendo vazio")
    public void NaoRetornarEnderecoDoProfessorVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEndereco(""));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do professor tendo menos de 3 letras")
    public void NaoRetornarEnderecoDoProfessorMenorQue3Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEndereco("ru"));
    }
    @Test
    @DisplayName("Não deve retornar o endereço do professor tendo mais de 50 letras")
    public void NaoRetornarEnderecoDoProfessorMaiorQue50Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEndereco("rua das oliveiras perdidas pelos campos do seu chris"));
    }
    //Especialidade
    @Test
    @DisplayName("deve retornar o Especialidade do profesor")
    public void DeveRetornarEspecialidadeDoProfessor() {

        Assertions.assertEquals(endereco, professor.getEndereco());
    }
    @Test
    @DisplayName("Não deve retornar o Especialidade do professor sendo nulo")
    public void NaoRetornarEspecialidadeDoProfessorNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEspecialidade(null));
    }
    @Test
    @DisplayName("Não deve retornar o Especialidade do professor sendo vazio")
    public void NaoRetornarEspecialidadeDoProfessorVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEspecialidade(""));
    }
    @Test
    @DisplayName("Não deve retornar o Especialidade do professor tendo menos de 3 letras")
    public void NaoRetornarEspecialidadeDoProfessorMenorQue3Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEspecialidade("FS"));
    }
    @Test
    @DisplayName("Não deve retornar o Especialidade do professor tendo mais de 30 letras")
    public void NaoRetornarEspecialidadeDoProfessorMaiorQue50Letras() {

        Assertions.assertThrows(RuntimeException.class, () -> professor.setEspecialidade("Programador Full Stack Especializado em react com angular e sql"));
    }

    //Testes de integração

    @Test
    @DisplayName("Deve haver 3 turmas em professor")
    public void adicionarTurmasEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        Assertions.assertEquals(3, professor.getTurma().size(),"Deve haver 3 turmas em professor");
    }

    @Test
    @DisplayName("Deve remover apenas 1 turma em professor")
    public void remover1TurmasEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        boolean removido = professor.getTurma().remove(turma1);

        Assertions.assertTrue(removido, "Deve remover a 'turma1' com sucesso");
        Assertions.assertEquals(2, professor.getTurma().size(),"Deve retornar 2 turmas no professor");
    }

    @Test
    @DisplayName("Deve remover apenas 3 turma em professor")
    public void remover3TurmasEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        boolean removido1 = professor.getTurma().remove(turma1);
        boolean removido12 = professor.getTurma().remove(turma12);
        boolean removido123 = professor.getTurma().remove(turma123);


        Assertions.assertTrue(removido1, "Deve remover a 'turma1' com sucesso");
        Assertions.assertTrue(removido12, "Deve remover a 'turma12' com sucesso");
        Assertions.assertTrue(removido123, "Deve remover a 'turma123' com sucesso");

        Assertions.assertEquals(0, professor.getTurma().size(),"Deve retornar 0 turmas no professor");
    }

    @Test
    @DisplayName("Deve retornar a turma buscada em professor")
    public void buscarTurmaPorSemestreEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        Optional<Turma> turmaEncontrada = professor.getTurma().stream().filter(turma -> turma.getSemestre().equals(1)).findFirst();

        Assertions.assertTrue(turmaEncontrada.isPresent(),"Deve encontrar o Semestre 1");
    }

    @Test
    @DisplayName("Buscar Turma Por Ano Em Professor")
    public void buscarTurmaPorAnoEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        Optional<Turma> turmaEncontrada = professor.getTurma().stream().filter(turma -> turma.getAno().equals(2020)).findFirst();

        Assertions.assertTrue(turmaEncontrada.isPresent(),"Deve encontrar o Ano 2020");
    }

    @Test
    @DisplayName("Deve retornar o Ano especificado em professor")
    public void retornarAnoEmProfessor(){

        Turma turma1 = new Turma(1,2020);
        Turma turma12 = new Turma(2,2021);
        Turma turma123 = new Turma(3,2022);

        ArrayList<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma12);
        turmas.add(turma123);
        professor.setTurma(turmas);

        Optional<Turma> turmaEncontrada = professor.getTurma().stream().filter(turma -> turma.getAno().equals(2022)).findFirst();

        Assertions.assertEquals(2022,turmaEncontrada.get().getAno(),"O ano encontrado deve ser 2022");
    }

}
