package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import frutuoso.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.ToString;


@Entity
@Table(name = "tb_cadastro")

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

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes_model;

    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, int idade, String rank, MissoesModel missoes_model) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.rank = rank;
        this.missoes_model = missoes_model;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public MissoesModel getMissoes_model() {
        return missoes_model;
    }

    public void setMissoes_model(MissoesModel missoes_model) {
        this.missoes_model = missoes_model;
    }
}
