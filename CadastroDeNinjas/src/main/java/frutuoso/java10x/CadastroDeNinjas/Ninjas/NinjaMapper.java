package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDto ninjaDto){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDto.getId());
        ninjaModel.setNome(ninjaDto.getNome());
        ninjaModel.setEmail(ninjaDto.getEmail());
        ninjaModel.setIdade(ninjaDto.getIdade());
        ninjaModel.setRank(ninjaDto.getRank());
        ninjaModel.setMissoes_model(ninjaDto.getMissoes_model());

        return ninjaModel;
    }

    public NinjaDto map(NinjaModel ninjaModel){
        NinjaDto ninjaDto = new NinjaDto();
        ninjaDto.setId(ninjaModel.getId());
        ninjaDto.setNome(ninjaModel.getNome());
        ninjaDto.setEmail(ninjaModel.getEmail());
        ninjaDto.setIdade(ninjaModel.getIdade());
        ninjaDto.setRank(ninjaModel.getRank());
        ninjaDto.setMissoes_model(ninjaModel.getMissoes_model());

        return  ninjaDto;
    }
}
