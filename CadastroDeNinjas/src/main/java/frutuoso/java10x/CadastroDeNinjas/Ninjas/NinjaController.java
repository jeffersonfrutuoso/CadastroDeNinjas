package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Meu primeiro programa em java, me sinto sujo";
    }

    @GetMapping("/mostrarTodos")
    public String mostrarTodos() {
        return "mostrando todos";
    }

    @GetMapping("/mostrarID")
    public String mostrarPorId() {
        return "mostrando por id";
    }

    @PostMapping("/Create")
    public String Criando() {
        return "criando";
    }

    @PutMapping("/Atualizar")
    public String Atualizando() {
        return "Atualizar";
    }

    @DeleteMapping("/Deletar")
    public String Deletar() {
        return "Delatando";
    }

}
