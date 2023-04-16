package br.com.projetomensal02.Service;

import br.com.projetomensal02.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private AlunoRepository alunoRepository;
}
