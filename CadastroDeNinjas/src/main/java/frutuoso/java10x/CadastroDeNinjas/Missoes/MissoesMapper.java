package frutuoso.java10x.CadastroDeNinjas.Missoes;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDto missoesDto){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDto.getId());
        missoesModel.setNome(missoesDto.getNome());
        missoesModel.setDificuldade(missoesDto.getDificuldade());
        missoesModel.setNinja_model(missoesDto.getNinja_model());

        return missoesModel;
    }

    public MissoesDto map(MissoesModel missoesModel){
        MissoesDto missoesDto = new MissoesDto();
        missoesDto.setId(missoesModel.getId());
        missoesDto.setNome(missoesModel.getNome());
        missoesDto.setDificuldade(missoesModel.getDificuldade());
        missoesDto.setNinja_model(missoesModel.getNinja_model());

        return missoesDto;
    }
}
