package br.com.projetomensal02;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Curso;
import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Entity.Turma;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

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

    // Teste unitário //
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

    // Teste de integração //
    @Test
    @DisplayName("Deve adicionar curso na turma")
    public void testAdicionarCurso(){
        Curso curso1 = new Curso("software", "eng");

        turma.setCurso(curso1);

        Assertions.assertEquals(curso1, turma.getCurso(),"Deve haver um curso");
    }

    @Test
    @DisplayName("Deve adicionar uma lista de alunos")
    public void testAdicionarAlunos() {


        Aluno aluno1 = new Aluno("Jão", 20, "rua fulana");
        Aluno aluno2 = new Aluno("Allyson", 21, "rua siclana");
        Aluno aluno3 = new Aluno("Lucas", 22, "rua beltrana");


        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        turma.setAluno((List<Aluno>) alunos);

        //List<Aluno> alunos = turma.getAluno();

        Assertions.assertEquals(3, turma.getAluno().size(), "Deve haver 3 alunos na turma");
    }

    @Test
    @DisplayName("Deve remover um aluno")
    public void testRemoverAlunos() {


        Aluno aluno1 = new Aluno("Jão", 20, "rua fulana");
        Aluno aluno2 = new Aluno("Allyson", 21, "rua siclana");
        Aluno aluno3 = new Aluno("Lucas", 22, "rua beltrana");


        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        turma.setAluno((List<Aluno>) alunos);

        boolean removido = turma.getAluno().remove(aluno1);

        Assertions.assertTrue(removido, "Deve remover 'aluno1' com sucesso");
        Assertions.assertEquals(2, turma.getAluno().size(), "Deve haver 2 alunos na turma");
    }

    @Test
    @DisplayName("Deve adicionar uma lista de professores")
    public void testAdicionarProfessores() {


        Professor professor1 = new Professor("Jão", "rua fulano", "JavaScript");
        Professor professor2 = new Professor("Allyson", "rua ciclano", "java");
        Professor professor3 = new Professor("Lucas", "rua beltrano", "Node.js");


        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
        turma.setProfessor((List<Professor>) professores);

        Assertions.assertEquals(3, turma.getProfessor().size(), "Deve haver 3 professores na turma");
    }

    @Test
    @DisplayName("Deve remover um professor")
    public void testRemoverProfessores() {


        Professor professor1 = new Professor("Jão", "rua fulano", "JavaScript");
        Professor professor2 = new Professor("Allyson", "rua ciclano", "java");
        Professor professor3 = new Professor("Lucas", "rua beltrano", "Node.js");


        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
        turma.setProfessor((List<Professor>) professores);

        boolean removido = turma.getProfessor().remove(professor1);

        Assertions.assertTrue(removido, "Deve remover 'professor1' com sucesso");
        Assertions.assertEquals(2, turma.getProfessor().size(), "Deve haver 2 professores na turma");
    }
}
