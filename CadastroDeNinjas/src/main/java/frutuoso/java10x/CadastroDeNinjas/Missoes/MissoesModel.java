package frutuoso.java10x.CadastroDeNinjas.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import frutuoso.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "tb_missoes")

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    @OneToMany(mappedBy = "missoes_model", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<NinjaModel> ninja_model;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String dificuldade, List<NinjaModel> ninja_model) {
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
