package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import frutuoso.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes_model;

    public NinjaModel() {
    }

    public NinjaModel(Long id, String nome, String email, int idade, MissoesModel missoes_model) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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

    public MissoesModel getMissoes_model() {
        return missoes_model;
    }

    public void setMissoes_model(MissoesModel missoes_model) {
        this.missoes_model = missoes_model;
    }
}
