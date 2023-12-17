import classes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private ArrayList<Solicitacao> lerSolicitacao(){
        try{
            File arquivo = new File("./Solicitacoes.txt");
            Scanner leitor = new Scanner(arquivo);
            ArrayList <Solicitacao> solicitacoes = new ArrayList<>();
            String linha, tipo;

            while (leitor.hasNextLine()){
                linha = leitor.nextLine();
                tipo = "";
                for(int i = 0; linha.charAt(i) != ';'; i++){
                    tipo += linha.charAt(i);
                }
                if(tipo.equalsIgnoreCase("FIXA")){
                    Solicitacao_Fixa solicitacao = new Solicitacao_Fixa("", "", "", 0, "", "");
                    solicitacao.leLinhaECadastra(linha);
                }
            }

        }catch (FileNotFoundException e){

        }

    }

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