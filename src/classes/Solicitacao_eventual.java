package classes;

import classes.Solicitacao;

public class Solicitacao_eventual extends Solicitacao {
    public String finalidade;

    public Solicitacao_eventual(String ano, String semestre, String curso, int vagas, String horarios, String finalidade) {
        super(ano, semestre, curso, vagas, horarios);
        this.finalidade = finalidade;
    }

    public String toString(){
        return "Solicitação: Ano: "+this.Ano+", Semestre: "+this.Semestre+", Curso: "+this.Curso+", Vagas: "+this.Vagas+", Horários: "+this.Horarios+", Finalidade: "+this.finalidade+";";
    }
}
