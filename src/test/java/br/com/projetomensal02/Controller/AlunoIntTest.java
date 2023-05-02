package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Entity.Aluno;
import br.com.projetomensal02.Entity.Curso;
import br.com.projetomensal02.Entity.Professor;
import br.com.projetomensal02.Entity.Turma;
import br.com.projetomensal02.Repository.AlunoRepository;
import br.com.projetomensal02.Repository.CursoRepository;
import br.com.projetomensal02.Repository.ProfessorRepository;
import br.com.projetomensal02.Repository.TurmaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Builder
class AlunoIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    void insertListOfAluno(){
        Aluno[] listaDeAlunos = new Aluno[]{
                Aluno.builder().nome("Fulano1").idade(21).endereco("Lugar 1").build(),
                Aluno.builder().nome("Fulano2").idade(22).endereco("Lugar 2").build(),
                Aluno.builder().nome("Fulano3").idade(23).endereco("Lugar 3").build(),
        };
        alunoRepository.saveAll(Arrays.stream(listaDeAlunos).toList());
    }
    void insertListOfCurso(){
        Curso[] listaDeCursos = new Curso[]{
                Curso.builder().nome("Engenharia de Software").sigla("ENG-SOFT").build(),
                Curso.builder().nome("Arquitetura").sigla("ARQ").build()
        };
        cursoRepository.saveAll(Arrays.stream(listaDeCursos).toList());
    }

    void insertListOfProfessor(){
        Professor[] listaDeProfessores = new Professor[]{
                Professor.builder().nome("Ciclano1").especialidade("Java").endereco("Lugar 4").build(),
                Professor.builder().nome("Ciclano2").especialidade("Suspensão").endereco("Lugar 5").build(),
                Professor.builder().nome("Ciclano3").especialidade("Geral").endereco("Lugar 6").build(),
        };
        professorRepository.saveAll(Arrays.stream(listaDeProfessores).toList());
    }
//    void insertListOfTurma(){
//        Turma[] listaDeTurmas = new Turma[]{
//                Turma.builder().semestre(4).ano(4).
//                Professor.builder().nome("Ciclano2").especialidade("Suspensão").endereco("Lugar 5").build(),
//                Professor.builder().nome("Ciclano3").especialidade("Geral").endereco("Lugar 6").build(),
//        };
//        professorRepository.saveAll(Arrays.stream(listaDeProfessores).toList());
//    }


    @BeforeEach
    void setup() {
        turmaRepository.deleteAll();
        alunoRepository.deleteAll();
        professorRepository.deleteAll();
        cursoRepository.deleteAll();
        insertListOfAluno();
        insertListOfCurso();
        insertListOfProfessor();

    }


    @Test
    void listAll() throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/api/aluno"));
        resultActions.andExpect(status().isOk());
        var responseList = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class);
        Assertions.assertEquals(3, responseList.length);
        Assertions.assertEquals("Fulano1", responseList[0].getNome());
    }

    @Test
    void findById() throws Exception {
        var alunos = alunoRepository.findAll();
        var alunoId = alunos.get(0).getId();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/" + alunoId));
        resultActions.andExpect(status().isOk());
        var response = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno.class);
        Assertions.assertEquals(alunoId,response.getId());

    }


    @Test
    void findAlunoByNome() throws Exception {
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/nome/" + alunoNome));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());

    }

    @Test
    void findAllAlunoByCurso() throws Exception {
        var cursos = cursoRepository.findAll();
        var cursoNome = cursos.get(0).getNome();
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/curso/nome/" + cursoNome));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());
    }

    @Test
    void findAllAlunoBySiglaCurso() throws Exception {
        var cursos = cursoRepository.findAll();
        var cursoSigla = cursos.get(0).getSigla();
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/curso/sigla/" + cursoSigla));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());
    }

    @Test
    void findAllAlunoBySemestreTurma() throws Exception {
        var turmas = turmaRepository.findAll();
        var turmaSemestre = turmas.get(0).getSemestre();
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/turma/semestre/" + turmaSemestre));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());
    }

    @Test
    void findAllAlunoByAnoTurma() throws Exception {
        var turmas = turmaRepository.findAll();
        var turmaAno = turmas.get(0).getAno();
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get("/api/aluno/turma/ano/" + turmaAno));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());
    }

    @Test
    void findAllAlunoByCursoAndTurma() throws Exception {
        var turmas = turmaRepository.findAll();
        var turmaAno = turmas.get(0).getAno();
        var cursos = cursoRepository.findAll();
        var cursoNome = cursos.get(0).getNome();
        var alunos = alunoRepository.findAll();
        var alunoNome = alunos.get(0).getNome();
        ResultActions resultActions = mockMvc.perform(get
                ("/api/aluno/cursoAndTurma/" + cursoNome +"/"+turmaAno));
        resultActions.andExpect(status().isOk());
        var response = Arrays.stream(objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), Aluno[].class)).findFirst().orElse(null);
        Assertions.assertEquals(alunoNome,response.getNome());
    }

    @Test
    void save() throws Exception {
        Aluno aluno = Aluno.builder().nome("Paulo 21").idade(40).endereco("Lugar Qualquer").build();

        ResultActions response = mockMvc.perform(post("/api/aluno")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aluno)));

        response.andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {
        Aluno aluno = Aluno.builder().nome("Nome Atualizado").idade(33).endereco("Lugar Novo").build();
        var alunos = alunoRepository.findAll();
        var alunoId = alunos.get(0).getId();
        ResultActions resultActions = mockMvc.perform(put("/api/aluno/" + alunoId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(aluno)));
        resultActions.andExpect(status().isOk());
        var updatedAluno = alunoRepository.findById(alunoId).orElse(new Aluno());
        Assertions.assertEquals(aluno.getNome(), updatedAluno.getNome());
    }

    @Test
    void deleteAluno() throws Exception {
        var alunos = alunoRepository.findAll();
        var alunoId = alunos.get(0).getId();
        ResultActions resultActions = mockMvc.perform(delete("/api/aluno/" + alunoId));
        resultActions.andExpect(status().isOk());
    }

}