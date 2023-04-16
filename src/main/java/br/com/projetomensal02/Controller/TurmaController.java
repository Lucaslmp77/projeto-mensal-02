package br.com.projetomensal02.Controller;

import br.com.projetomensal02.Service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;
}
