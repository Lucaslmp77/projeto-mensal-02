package br.com.projetomensal02;
import br.com.projetomensal02.Entity.Professor;
import org.junit.jupiter.api.*;
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
}
