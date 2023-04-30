package br.com.projetomensal02;

import br.com.projetomensal02.Entity.Turma;
import org.junit.jupiter.api.*;

public class TurmaTest {

    private Turma turma;

    private static Integer semestre;

    private static Integer ano;

    @BeforeAll
    public static void setarValoresPadrao() {

        semestre = 2;
        ano = 2023;
    }

    @BeforeEach
    public void inicializarTurma() {

        turma = new Turma(semestre, ano);
    }

    @Test
    @DisplayName("Deve retornar o semestre")
    public void deveRetornarOSemestre() {

        Assertions.assertEquals(semestre, turma.getSemestre());
    }

    @Test
    @DisplayName("Não deve receber valor de semestre nulo")
    public void naoDeveReceberSemestreNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> turma.setSemestre(null));
    }

    @Test
    @DisplayName("Não deve receber valor de semestre menor ou igual a 0")
    public void naoDeveReceberSemestreMenorOuIgualAZero() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.setSemestre(0));
    }

    @Test
    @DisplayName("Não deve receber valor de ano maior que 10")
    public void naoDeveReceberSemestreMaiorQueDez() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.setSemestre(11));
    }

    @Test
    @DisplayName("Deve retornar o ano")
    public void deveRetornarOAno() {

        Assertions.assertEquals(ano, turma.getAno());
    }

    @Test
    @DisplayName("Não deve receber valor de ano nulo")
    public void naoDeveReceberAnoNulo() {

        Assertions.assertThrows(RuntimeException.class, () -> turma.setAno(null));
    }

    @Test
    @DisplayName("Não deve receber valor de ano menor ou igual a 0")
    public void naoDeveReceberAnoMenorOuIgualAZero() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.setAno(0));
    }

    @Test
    @DisplayName("Não deve receber valor de ano maior que 10")
    public void naoDeveReceberAnoMaiorQueDez() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.setAno(11));
    }
}
