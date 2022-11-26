package classes;

public abstract class Pessoa {

    private String nome;
    private int cpf;

    public Pessoa() {

    }

    public Pessoa(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract Piloto getPiloto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Pessoa(int cpf) {
        this.cpf = cpf;
    }

}
