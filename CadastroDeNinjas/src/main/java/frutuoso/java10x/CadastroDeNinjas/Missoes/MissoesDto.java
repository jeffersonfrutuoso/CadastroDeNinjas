package frutuoso.java10x.CadastroDeNinjas.Missoes;
import frutuoso.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import java.util.List;

public class MissoesDto {
    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja_model;

    public MissoesDto() {
    }

    public MissoesDto(Long id, String nome, String dificuldade, List<NinjaModel> ninja_model) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninja_model = ninja_model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<NinjaModel> getNinja_model() {
        return ninja_model;
    }

    public void setNinja_model(List<NinjaModel> ninja_model) {
        this.ninja_model = ninja_model;
    }
}
