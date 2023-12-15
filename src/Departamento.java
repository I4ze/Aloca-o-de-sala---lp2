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

        return false;
    }

    private boolean verificaDisponibilidade(String horario, Sala sala){
        try{
            File arquivo = new File("./Relatorio_alocados.txt");
            Scanner leitor = new Scanner(arquivo);


            String linha, localizacao, horarioAux;
            int posicao;
            while (leitor.hasNextLine()) {
                linha = leitor.nextLine();
                localizacao = "";
                horarioAux = "";

                posicao = linha.indexOf("Localização: ");
                if (posicao != -1) {
                    posicao += "Localização: ".length();
                    for (; posicao <= linha.length() - 1 && linha.charAt(posicao) != ';'; posicao++) {
                        localizacao += linha.charAt(posicao);
                    }

                    if (localizacao.equalsIgnoreCase(sala.localizacao)) {
                        posicao = linha.indexOf("Horários: ");
                        if (posicao != -1) {
                            posicao += "Horários: ".length();
                            for (; posicao <= linha.length() - 1 && linha.charAt(posicao) != ','; posicao++) {
                                horarioAux += linha.charAt(posicao);
                            }

                            HorarioSigaa horarioArq = new HorarioSigaa(), horarioSolicitacao = new HorarioSigaa();
                            horarioArq = horarioArq.converteParaSigaa(horarioAux);
                            horarioSolicitacao = horarioSolicitacao.converteParaSigaa(horario);
                            if (verificaOcorrencia(horarioArq.diaSemana, horarioSolicitacao.diaSemana)) {
                                if (horarioArq.turno == horarioSolicitacao.turno) {
                                    if (verificaOcorrencia(horarioArq.horaDoDia, horarioSolicitacao.horaDoDia)) {
                                        return false;
                                    }
                                }
                            }
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
        Sala salaEscolhida = salasDisponiveis.get(0);
        for(Sala s: salasDisponiveis){
            if(s.capacidade == solicitacao.Vagas){
                if(verificaDisponibilidade(solicitacao.Horarios, s)){
                    registrarNoArquivo(solicitacao, s);
                    return s;
                };
            }
        }

        for(Sala s: salasDisponiveis){
            if(s.capacidade > solicitacao.Vagas){
                if(verificaDisponibilidade(solicitacao.Horarios, s)){
                    registrarNoArquivo(solicitacao, s);
                    return s;
                }
            }
        }

        return null;
    }
}
