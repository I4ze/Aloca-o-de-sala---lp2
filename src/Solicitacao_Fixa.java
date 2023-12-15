public class Solicitacao_Fixa extends Solicitacao{
    public String Disciplina;

    public Solicitacao_Fixa(String ano, String semestre, String curso, int vagas, String horarios, String disciplina) {
        super(ano, semestre, curso, vagas, horarios);
        this.Disciplina = disciplina;
    }

    public String toString(){
        return "Solicitação: Ano: "+this.Ano+", Semestre: "+this.Semestre+", Curso: "+this.Curso+", Vagas: "+this.Vagas+", Horários: "+this.Horarios+", Disciplina: "+this.Disciplina+";";
    }
}
