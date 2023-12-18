package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Departamento {
    private boolean verificaOcorrencia(String str1, String str2){
        for(char c:str2.toCharArray()){
            for(char c2:str1.toCharArray()){
                if(c == c2){
                    return true;
                }
            }
        }
        //função pra ajudar a verificar se pelo menos um dia da semana ou um horario do dia bate

        return false;
    }

    private boolean registrarNoArquivo(Solicitacao solicitacao, Sala s){
        try{
            BufferedWriter escritor = new BufferedWriter(new FileWriter("./Relatorio_alocados.txt", true));
            escritor.write(solicitacao.toString()+s.toString()+'\n');
            escritor.close();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        //so abre o arquivo e escreve a solicitação seguida da sala no arquivo e uma quebra de linha.

        return false;
    }

    private boolean verificaDisponibilidade(String horario, Sala sala){
        try{
            File arquivo = new File("./Relatorio_alocados.txt");
            Scanner leitor = new Scanner(arquivo);
            //abre arquivo de solicitações já aprovadas, se ele existir, para verificar choques de horario e sala
            String linha, localizacao, horarioAux;
            int posicao;
            while (leitor.hasNextLine()) {
                linha = leitor.nextLine();
                localizacao = "";
                horarioAux = "";
                //pega linha por linha
                posicao = linha.indexOf("Localização: ");
                if (posicao != -1) {
                    posicao += "Localização: ".length();
                    for (; posicao <= linha.length() - 1 && linha.charAt(posicao) != ';'; posicao++) {
                        localizacao += linha.charAt(posicao);
                    } //gambi pra pegar a localizacao :)

                    //se localizacao da solicitacao atual for igual a sala recebida, vale a pena verificar se ta ocorrendo choque:
                    if (localizacao.equalsIgnoreCase(sala.localizacao)) {
                        posicao = linha.indexOf("Horários: ");
                        if (posicao != -1) {
                            posicao += "Horários: ".length();
                            for (; posicao <= linha.length() - 1 && linha.charAt(posicao) != ','; posicao++) {
                                horarioAux += linha.charAt(posicao);
                            } //gambi pra pegar o horario da solicitacao atual

                            HorarioSigaa horarioArq = new HorarioSigaa(), horarioSolicitacao = new HorarioSigaa();
                            horarioArq.converteParaSigaa(horarioAux);
                            horarioSolicitacao.converteParaSigaa(horario);
                            //convertendo pro objeto horarioSigaa pra facilitar a comparacao.
                            if (verificaOcorrencia(horarioArq.getDiaSemana(), horarioSolicitacao.getDiaSemana())){//se houver pelo menos um dia que bate, continua
                                if (horarioArq.getTurno() == horarioSolicitacao.getTurno()) {//se o turno também bater, continua:
                                    if (verificaOcorrencia(horarioArq.getHoraDoDia(), horarioSolicitacao.getHoraDoDia())) {
                                        return false;
                                    }
                                }
                            }
                            //codigo um pouco bagunçado mas funciona :)
                        }
                    }
                }

            }
        }
        catch(IOException e){
            System.out.println("Ainda não há registro de solicitações aprovadas");
        }
        return true;
    }

    public Sala alocarAula(Solicitacao solicitacao, ArrayList<Sala> salasDisponiveis){
        Sala salaEscolhida = null;
        for(Sala s: salasDisponiveis){
            if(s.capacidade == solicitacao.getVagas() && !(s instanceof Sala_Aula && solicitacao instanceof Solicitacao_eventual)){
                if(verificaDisponibilidade(solicitacao.getHorarios(), s)){
                    registrarNoArquivo(solicitacao, s);
                    return s;
                };
            }
        }
//        dois laços para procurar primeiro por uma sala que tenha exatamente a capacidade requisitada.
//        Caso nao encontre, procura uma que tenha maior capacidade. Variavel salaEscolhida é usada como auxiliar para escolher a sala com menor
//        capacidade que atenda a solicitação. Um jeito de otimizar a escolha.
        for(Sala s: salasDisponiveis){
            if(s.capacidade > solicitacao.getVagas()  && !(s instanceof Sala_Aula && solicitacao instanceof Solicitacao_eventual)){
                if(verificaDisponibilidade(solicitacao.getHorarios(), s)){
                    try{
                        if(s.capacidade<salaEscolhida.capacidade){ //try catch pra evitar usar muito if :)
                            salaEscolhida = s;
                        }
                    }catch (NullPointerException e){
                        salaEscolhida = s;
                    }
                }
            }
        }

        if(salaEscolhida != null){
            registrarNoArquivo(solicitacao, salaEscolhida);
        }
        return salaEscolhida;
    }
}
