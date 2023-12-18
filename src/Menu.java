import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import classes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
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
                    solicitacoes.add(solicitacao);
                }else if(tipo.equalsIgnoreCase("EVENTUAL")){
                    Solicitacao_eventual solicitacao = new Solicitacao_eventual("", "", "", 0, "", "", "", "");
                    solicitacao.leLinhaECadastra(linha);
                    solicitacoes.add(solicitacao);
                }
            }
            return solicitacoes;

        }catch (FileNotFoundException e){
            return null;
        }

    }
    public static void main(String[] args) {
         new MyFrame();
    }
}
