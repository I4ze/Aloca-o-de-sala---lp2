package classes;

import java.util.ArrayList;

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
}
