package classes;

public abstract class Solicitacao {
    private String Ano;
    private String Semestre;
    private String Curso;
    private int Vagas;
    private String Horarios;

    public Solicitacao(String ano, String semestre, String curso, int vagas, String horarios) {
        Ano = ano;
        Semestre = semestre;
        Curso = curso;
        Vagas = vagas;
        Horarios = horarios;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String ano) {
        Ano = ano;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String semestre) {
        Semestre = semestre;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public int getVagas() {
        return Vagas;
    }

    public void setVagas(int vagas) {
        Vagas = vagas;
    }

    public String getHorarios() {
        return Horarios;
    }

    public void setHorarios(String horarios) {
        Horarios = horarios;
    }
}
