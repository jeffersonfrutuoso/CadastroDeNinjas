package frutuoso.java10x.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lista todas as missoes" , description = "essa rota Lista todas as missoes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todas as missoes listadas"),
            @ApiResponse(responseCode = "400", description = "erro na listagem das missoes")
    })
    public ResponseEntity<List<MissoesDto>> listarMissoes() {
        List<MissoesDto> listaDeMissoes = missoesService.listarMissoes();
        return ResponseEntity.ok(listaDeMissoes);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar missoes por id" , description = "essa rota lista missoes por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "missao listada com sucesso"),
            @ApiResponse(responseCode = "404", description = "missao com esse id nao foi encontrado")
    })
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
    @Operation(summary = "cria uma nova missao" , description = "essa rota cria uma nova missao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "missao criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na criaçao da missao, tente novamente")
    })
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDto missoes) {
        MissoesDto novaMissao = missoesService.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("missao criada com sucesso: " + novaMissao.getNome() + " ID: " + novaMissao.getId());
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza uma missao" , description = "essa rota atualiza uma missao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "missao atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "erro na atualizaçao da missao, id nao encontrado")
    })
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
    @Operation(summary = "Deletar uma missao" , description = "essa rota deleta uma missao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "missao deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "missao com esse id nao encontrada")
    })
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id) {
        if(missoesService.listarPorId(id) != null){
            missoesService.deletarMissoes(id);
            return ResponseEntity.ok("missao com o id: " + id + " deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID:" + id + " nao foi encontrado, digite um id valido");
        }
    }
}
