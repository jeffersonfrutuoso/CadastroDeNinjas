package frutuoso.java10x.CadastroDeNinjas.Ninjas;

import frutuoso.java10x.CadastroDeNinjas.Missoes.MissoesModel;

public class NinjaDto {
    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missoes_model;

    public NinjaDto() {
    }

    public NinjaDto(Long id, String email, String nome, int idade, String rank, MissoesModel missoes_model) {
        this.id = id;
        this.email = email;
        this.nome = nome;
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
