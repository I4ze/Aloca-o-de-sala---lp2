package classes;

public class HorarioSigaa {
    public String diaSemana;
    public char turno;
    public String horaDoDia;

    public HorarioSigaa() {
        this.horaDoDia = "";
        this.turno = ' ';
        this.diaSemana = "";
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
