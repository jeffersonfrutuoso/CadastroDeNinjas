package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "mensagem de boas vindas" , description = "essa rota da uma mensagem de boas vindas")
    public String boasVindas() {
        return "Meu primeiro programa em java, me sinto sujo";
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas" , description = "essa rota Lista todos os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos os ninjas listados"),
            @ApiResponse(responseCode = "400", description = "erro na listagem dos ninjas")
    })
    public ResponseEntity<List<NinjaDto>> mostrarTodos() {
        List<NinjaDto> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninja por id" , description = "essa rota lista ninja por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ninja com esse id nao foi encontrado")
    })
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
        NinjaDto ninjaPorID =  ninjaService.listarNinjasPorId(id);
        if (ninjaPorID != null){
            return ResponseEntity.ok(ninjaPorID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja do ID " + id + " nao foi encontrado");
        }
    }

    @PostMapping("/Criar")
    @Operation(summary = "cria um novo ninja" , description = "essa rota cria um novo ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "erro na criaçao do ninja, tente novamente")
    })
    public ResponseEntity<String> Criando(@RequestBody NinjaDto ninja) {
        NinjaDto novoNinja =  ninjaService.CriarNinjas(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza um ninja" , description = "essa rota atualiza um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "erro na atualizaçao do ninja, id nao encontrado")
    })
    public ResponseEntity<?> AtualizarNinja(@PathVariable Long id, @RequestBody NinjaDto ninjaAtualizado)
    {
        NinjaDto ninja =  ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o Id: " + id + " nao foi encontrado");
        }

    }

    @DeleteMapping("/Deletar/{id}")
    @Operation(summary = "Deletar um ninja" , description = "essa rota deleta um ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ninja com esse id nao encontrado")
    })
    public ResponseEntity<String> Deletar(@PathVariable Long id)
    {
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("O Ninja com o ID " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " nao foi encontrado, exclua um id existente");
        }
    }

}
