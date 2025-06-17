package frutuoso.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MissoesDto>> listarMissoes() {
        List<MissoesDto> listaDeMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id) {
        MissoesDto missaoPorID = missoesService.listarPorId(id);
        if (missaoPorID != null){
            return ResponseEntity.ok(missaoPorID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("missao com o id " + id + " nao foi encontrado ");
        }

    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDto missoes) {
        MissoesDto novaMissao = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("missao criada com sucesso: " + novaMissao.getNome() + " ID: " + novaMissao.getId());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissoes(@PathVariable Long id, @RequestBody MissoesDto missaoAtualizada)
    {
        MissoesDto missao = missoesService.atualizarMissao(id, missaoAtualizada);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("missao com o id: " + id + " nao encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        if(missoesService.listarPorId(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("ninja com o id: " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID:" + id + " nao foi encontrado, digite um id valido");
        }
    }
}
