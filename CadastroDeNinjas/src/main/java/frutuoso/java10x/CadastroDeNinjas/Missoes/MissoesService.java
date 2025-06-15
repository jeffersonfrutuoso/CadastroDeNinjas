package frutuoso.java10x.CadastroDeNinjas.Missoes;
import frutuoso.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarMissoes () {
        return missoesRepository.findAll();
    }

    public MissoesModel listarPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    public void deletarMissoes (Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesModel atualizarMissao(Long id, MissoesModel missaoAtualizada) {
        if(missoesRepository.existsById(id)){
            missaoAtualizada.setId(id);
           return missoesRepository.save(missaoAtualizada);
        }
        return null;
    }


}
