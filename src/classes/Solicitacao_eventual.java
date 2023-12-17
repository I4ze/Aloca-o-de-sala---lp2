package classes;

import classes.Solicitacao;

public class Solicitacao_eventual extends Solicitacao {
    public String finalidade;

    public Solicitacao_eventual(String ano, String semestre, String curso, int vagas, String horarios, String finalidade) {
        super(ano, semestre, curso, vagas, horarios);
        this.finalidade = finalidade;
    }

    public void leLinhaECadastra(){
        
    }

    public String toString(){
        return "Solicitação: Ano: "+this.getAno()+", Semestre: "+this.getSemestre()+", Curso: "+this.getCurso()+", Vagas: "+this.getVagas()+", Horários: "+this.getHorarios()+", Finalidade: "+this.finalidade+";";
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }
}
