package classes;

public class HorarioSigaa {
    private String diaSemana;
    private char turno;
    private String horaDoDia;

    public HorarioSigaa() {
        this.horaDoDia = "";
        this.turno = ' ';
        this.diaSemana = "";
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public String getHoraDoDia() {
        return horaDoDia;
    }

    public void setHoraDoDia(String horaDoDia) {
        this.horaDoDia = horaDoDia;
    }

    public HorarioSigaa converteParaSigaa(String horario){
        HorarioSigaa hora = new HorarioSigaa();
        int i=0;
        for(;i<horario.length() && Character.isDigit(horario.charAt(i)); i++){
            hora.diaSemana += horario.charAt(i);
        }

        hora.turno = horario.charAt(i);
        i++;
        for(;i<horario.length() && Character.isDigit(horario.charAt(i)); i++){
            hora.horaDoDia += horario.charAt(i);
        }

        return hora;
    }
}
