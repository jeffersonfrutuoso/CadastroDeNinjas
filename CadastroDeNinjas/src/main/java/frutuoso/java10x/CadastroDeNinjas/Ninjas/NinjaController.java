package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Meu primeiro programa em java, me sinto sujo";
    }

    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodos() {
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasPorId(id);
    }

    @PostMapping("/Criar")
    public String Criando() {
        return "criado com sucesso";
    }

    @PutMapping("/Atualizar")
    public String Atualizando() {
        return "Atualizado com sucesso";
    }

    @DeleteMapping("/Deletar")
    public String Deletar() {
        return "Delatado com sucesso";
    }

}
