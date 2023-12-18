package classes;

import classes.Solicitacao;

import java.util.Scanner;

public class Solicitacao_eventual extends Solicitacao {
    private String finalidade;
    private String dataInicio;
    private String dataFim;

    public Solicitacao_eventual(String ano, String semestre, String curso, int vagas, String horarios, String finalidade, String datainicio, String dataFim) {
        super(ano, semestre, curso, vagas, horarios);
        this.finalidade = finalidade;
        this.dataInicio = datainicio;
        this.dataFim = dataFim;
    }

    public void leLinhaECadastra(String linha){
        String campoAtual = "";
        int contaCampos = 0;
        Scanner scanner = new Scanner(linha).useDelimiter(";");
        while(scanner.hasNext()) {
            campoAtual = scanner.next();
            if (contaCampos == 0) {
                contaCampos++;
            } else if (contaCampos == 1) {
                this.setAno(campoAtual);
                contaCampos++;
            } else if (contaCampos == 2) {
                this.setSemestre(campoAtual);
                contaCampos++;
            } else if (contaCampos == 3) {
                this.setCurso(campoAtual);
                contaCampos++;
            } else if (contaCampos == 4) {
                this.setFinalidade(campoAtual);
                contaCampos++;
            } else if (contaCampos == 5) {
                this.setVagas(Integer.parseInt(campoAtual));
                contaCampos++;
            } else if (contaCampos == 6) {
                this.setHorarios(campoAtual);
                contaCampos++;
            } else if (contaCampos == 7) {
                this.setDataInicio(campoAtual);
                contaCampos++;
            } else{
                this.setDataFim(campoAtual);
            }
        }
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
