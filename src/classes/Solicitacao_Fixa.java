package classes;

import classes.Solicitacao;

import java.util.Scanner;

public class Solicitacao_Fixa extends Solicitacao {
    private String Disciplina;

    public Solicitacao_Fixa(String ano, String semestre, String curso, int vagas, String horarios, String disciplina) {
        super(ano, semestre, curso, vagas, horarios);
        this.Disciplina = disciplina;
    }

    public void leLinhaECadastra(String linha){
        String campoAtual = "";
        int contaCampos = 0;
        Scanner scanner = new Scanner(linha).useDelimiter(";");
        while(scanner.hasNext()){
            campoAtual = scanner.next();
            if(contaCampos == 0){
                contaCampos++;
            } else if(contaCampos == 1){
                this.setAno(campoAtual);
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 2) {
                this.setSemestre(campoAtual);
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 3) {
                this.setCurso(campoAtual);
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 4) {
                this.setDisciplina(campoAtual);
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 5) {
                this.setVagas(Integer.parseInt(campoAtual));
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 6) {
                this.setHorarios(campoAtual);
            }
        }
    }

    public String toString(){
        return "Solicitação: Ano: "+this.getAno()+", Semestre: "+this.getSemestre()+", Curso: "+this.getCurso()+", Vagas: "+this.getVagas()+", Horários: "+this.getHorarios()+", Disciplina: "+this.Disciplina+";";
    }

    public String getDisciplina() {
        return Disciplina;
    }

    public void setDisciplina(String disciplina) {
        Disciplina = disciplina;
    }
}
