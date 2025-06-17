package frutuoso.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDto> listarNinjas()
    {
        List<NinjaModel>  ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDto listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDto CriarNinjas( NinjaDto ninjaDto) {
        NinjaModel ninja =  ninjaMapper.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId(Long id ){
        ninjaRepository.deleteById(id);
    }

    public NinjaDto atualizarNinja(Long id, NinjaDto ninjaDto) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDto);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
