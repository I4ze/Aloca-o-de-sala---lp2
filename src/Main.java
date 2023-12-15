import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Departamento departamentoUFMA = new Departamento();
        Solicitacao_Fixa teste = new Solicitacao_Fixa("2023", "2", "Computations", 35, "24T23", "LP2");
        Solicitacao_Fixa teste2 = new Solicitacao_Fixa("2023", "2", "Computations", 35, "24T23", "LP2");
        Solicitacao_Fixa teste3 = new Solicitacao_Fixa("2023", "2", "Computations", 35, "24T23", "MDL");
        Sala_Auditorio sala1 = new Sala_Auditorio(35, "auditorio", "206");
        Sala_Aula sala2 = new Sala_Aula(45, "Saletinha", "205");
        ArrayList <Sala> salas = new ArrayList<Sala>();
        salas.add(sala1);
        salas.add(sala2);

        if(departamentoUFMA.alocarAula(teste, salas)!=null){
            System.out.println("Deu certoooo");
        }
        else {
            System.out.println("Nao foi :(");
        }

        if(departamentoUFMA.alocarAula(teste2, salas)!=null){
            System.out.println("Deu certoooo");
        }
        else {
            System.out.println("Nao foi :(");
        }

        if(departamentoUFMA.alocarAula(teste3, salas)!=null){
            System.out.println("Deu certoooo");
        }
        else {
            System.out.println("Nao foi :(");
        }

    }
}