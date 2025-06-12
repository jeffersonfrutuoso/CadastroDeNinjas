package frutuoso.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class missoesController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "listando todos";
    }

    @PostMapping("/criar")
    public String criarMissoes() {
        return "criado com sucesso";
    }

    @PutMapping("/atualizar")
    public String atualizarMissoes() {
        return "atualizado com sucesso ";
    }

    @DeleteMapping("/deletar")
    public String deletarMissoes() {
        return "deletado com sucesso ";
    }
}
