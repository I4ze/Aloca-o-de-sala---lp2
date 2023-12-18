package classes;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sala {
    public int capacidade;
    public String nome;
    public String localizacao;

    public Sala(int capacidade, String nome, String localizacao) {
        this.capacidade = capacidade;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String toString(){
        return "classes.Sala: Capacidade: "+this.capacidade+", Nome: "+this.nome+", Localização: "+this.localizacao+";";
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void leLinhaeCadastra(String linha){
        String campoAtual = "";
        int contaCampos = 0;
        Scanner scanner = new Scanner(linha).useDelimiter(";");
        while(scanner.hasNext()){
            campoAtual = scanner.next();
            if(contaCampos == 0){
                contaCampos++;
            } else if(contaCampos == 1){
                this.setCapacidade(Integer.parseInt(campoAtual));
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 2) {
                this.setNome(campoAtual);
                contaCampos++;
                campoAtual = "";
            } else if (contaCampos == 3) {
                this.setLocalizacao(campoAtual);
                campoAtual = "";
            }
        }
    }
}
