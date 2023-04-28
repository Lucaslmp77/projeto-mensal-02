package br.com.projetomensal02;

import br.com.projetomensal02.Entity.Curso;
import org.junit.jupiter.api.*;

public class CursoTest {
    private Curso curso;

    private static String nome;

    private static String sigla;

    @BeforeAll
    public static void definirValoresPadrao() {

        nome = "Engenharia de Software";
        sigla = "ES";
    }

    @BeforeEach
    public void inicializarCurso() {

        curso = new Curso(nome, sigla);
    }

    @Test
    @DisplayName("Deve retornar o nome")
    public void deveRetornarONome() {

        Assertions.assertEquals(nome, curso.getNome());
    }

    @Test
    @DisplayName("Não deve receber valor de nome nulo")
    public void naoDeveReceberNomeNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setNome(null));
    }

    @Test
    @DisplayName("Não deve receber valor de nome vazio")
    public void naoDeveReceberNomeVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setNome(""));
    }

    @Test
    @DisplayName("Não deve receber valor de nome com menos de 3 letras")
    public void naoDeveReceberNomeComMenosDeTresLetras() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setNome("ES"));
    }

    @Test
    @DisplayName("Não deve receber valor de nome com mais de 25 letras")
    public void naoDeveReceberNomeComMaisDeVinteECincoLetras() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setNome("Engenharia de agronomia e agricultura"));
    }

    @Test
    @DisplayName("Deve retornar a sigla")
    public void deveRetornarASigla() {

        Assertions.assertEquals(sigla, curso.getSigla());
    }

    @Test
    @DisplayName("Não deve receber valor de sigla nulo")
    public void naoDeveReceberValorDeSiglaNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setSigla(null));
    }

    @Test
    @DisplayName("Não deve receber valor de sigla vazio")
    public void naoDeveReceberValorDeSiglaVazio() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setSigla(""));
    }

    @Test
    @DisplayName("Não deve receber valor de sigla maior do que 10 letras")
    public void naoDevereceberValorDeSiglaMaiorQueDezLetras() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setSigla("ENGSOFTWARE"));
    }

    @Test
    @DisplayName("Não deve receber valor de sigla menor do que 2 letras")
    public void naoDeveReceberValorDeSiglaMenorQueDuasLetras() {

        Assertions.assertThrows(RuntimeException.class, () -> curso.setSigla("E"));
    }

}
