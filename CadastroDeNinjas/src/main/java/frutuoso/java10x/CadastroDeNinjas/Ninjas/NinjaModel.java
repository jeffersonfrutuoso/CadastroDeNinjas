package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import frutuoso.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes_model;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
