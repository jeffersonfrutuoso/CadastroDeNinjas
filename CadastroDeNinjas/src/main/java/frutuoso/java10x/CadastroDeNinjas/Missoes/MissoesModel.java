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
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
