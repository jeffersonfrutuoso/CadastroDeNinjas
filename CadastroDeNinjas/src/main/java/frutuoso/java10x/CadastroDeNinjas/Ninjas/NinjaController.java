package frutuoso.java10x.CadastroDeNinjas.Ninjas;

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
    public String boasVindas() {
        return "Meu primeiro programa em java, me sinto sujo";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDto>> mostrarTodos() {
        List<NinjaDto> listaDeNinjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaDeNinjas);
    }

    @GetMapping("/listar/{id}")
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
    public ResponseEntity<String> Criando(@RequestBody NinjaDto ninja) {
        NinjaDto novoNinja =  ninjaService.CriarNinjas(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    @PutMapping("/atualizar/{id}")
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
