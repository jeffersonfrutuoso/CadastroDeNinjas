package frutuoso.java10x.CadastroDeNinjas.Missoes;
import frutuoso.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDto> listarMissoes () {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDto listarPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDto criarMissao(MissoesDto missoesDto){
        MissoesModel missoes = missoesMapper.map(missoesDto);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    public void deletarMissoes (Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDto atualizarMissao(Long id, MissoesDto missoesDto) {
        Optional<MissoesModel> missoesExistentes = missoesRepository.findById(id);
        if(missoesExistentes.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDto);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return  null;
    }


}
