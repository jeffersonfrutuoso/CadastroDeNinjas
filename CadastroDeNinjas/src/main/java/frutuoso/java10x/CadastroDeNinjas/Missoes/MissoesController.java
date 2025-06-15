package frutuoso.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesModel listarMissoesPorId(@PathVariable Long id) {
        return missoesService.listarPorId(id);
    }

    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes) {
        return missoesService.criarMissao(missoes);
    }

    @PutMapping("/atualizar/{id}")
    public MissoesModel atualizarMissoes(@PathVariable Long id, @RequestBody MissoesModel missaoAtualizada)
    {
        return missoesService.atualizarMissao(id, missaoAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissoes(@PathVariable Long id) {
        missoesService.deletarMissoes(id);
    }
}
