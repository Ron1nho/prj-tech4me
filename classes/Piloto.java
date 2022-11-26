package classes;

public class Piloto extends Pessoa {
    private String breve;
    private int matricula;

    public Piloto() {

    }

    public Piloto(String nome, int cpf, String breve, int matricula) {
        super(nome, cpf);
        this.breve = breve;
        this.matricula = matricula;
    }

    public Piloto getPiloto() {
        return this;
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
