public abstract class Solicitacao {
    public String Ano;
    public String Semestre;
    public String Curso;
    public int Vagas;
    public String Horarios;

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

    public String getHorários() {
        return Horarios;
    }

    public void setHorários(String horarios) {
        Horarios = horarios;
    }
}
