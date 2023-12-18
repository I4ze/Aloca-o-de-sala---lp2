import classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;
import java.sql.SQLOutput;

public class MyFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    File file;

    private ArrayList<Sala> lerSalas(){
        try{
            File arquivo = new File("./Salas_disponiveis.txt");
            Scanner leitor = new Scanner(arquivo);
            ArrayList <Sala> salas = new ArrayList<>();
            String linha, campoAtual;
            int contaCampo;

            while(leitor.hasNextLine()){
                linha = leitor.nextLine();
                Scanner scanner = new Scanner(linha).useDelimiter(";");
                campoAtual = scanner.next();
                if(campoAtual.equalsIgnoreCase("sala")){
                    Sala_Aula sala = new Sala_Aula(0, "", "");
                    sala.leLinhaeCadastra(linha);
                    salas.add(sala);
                } else if (campoAtual.equalsIgnoreCase("auditorio")) {
                    Sala_Auditorio sala = new Sala_Auditorio(0, "", "");
                    sala.leLinhaeCadastra(linha);
                    salas.add(sala);
                }
            }
            return salas;

        }catch (FileNotFoundException e){
            return null;
        }
    }

    private ArrayList<Solicitacao> lerSolicitacao(File file){
        try{
            Scanner leitor = new Scanner(file);
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
    MyFrame(){
        ImageIcon arquivoOriginal = new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/arquivo.jpeg")));
        Image imagemRedimensionada = arquivoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Altere 100, 100 para o tamanho desejado
        ImageIcon arquivoRedimensionado = new ImageIcon(imagemRedimensionada);
        ImageIcon PF = new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/PF.jpg")));

        ImageIcon iconSIGAA =new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/logo.jpeg")));


        JLabel label = new JLabel();
        label.setText("Bem-Vindo ao SIGAA");
        label.setBackground(Color.WHITE);
        label.revalidate();
        label.repaint();
        label.setVisible(true);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBounds(50, 0,200, 100);
        label.setIcon(arquivoRedimensionado);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setBounds(0, 0, 500, 100);
        headerPanel.setLayout(null);
        headerPanel.add(label);

        JFrame frame = new JFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SIGAA GERALDO");
        this.setLayout(new FlowLayout());
        this.setSize(500, 500);
        this.add(label, BorderLayout.CENTER);
        this.add(headerPanel);
        this.setIconImage(iconSIGAA.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setResizable(false);

        //criando o menu

        menuBar = new JMenuBar();
        fileMenu = new JMenu("Arquivo");
        editMenu = new JMenu("Editar");
        helpMenu = new JMenu("Ajuda");

        loadItem = new JMenuItem("Carregar");
        saveItem = new JMenuItem("Ler solicitacoes");
        exitItem = new JMenuItem("Apagar arquivo");

        menuBar.setBackground(new Color(0x6C6CFF));
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    private void openNewWindow(String saida){
        // cria e mostra nova janela
        JLabel texto = new JLabel();
        texto.setOpaque(true);
        texto.setBackground(new Color(0x6C6CFF));
        texto.setForeground(new Color(0xFFFF00));
        texto.setText(saida);
        texto.setHorizontalTextPosition(JLabel.CENTER);
        JDialog successWindow = new JDialog(this, "Sucesso", false);
        successWindow.setSize(200,150);
        successWindow.add(texto);
        successWindow.setVisible(true);
        successWindow.setBounds(20, 20,150,150);
        successWindow.setResizable(false);
        successWindow.getContentPane().setBackground(new Color(0x6C6CFF));


    }
    private void mostrarConteudoDoArquivo(File file) {
        try {
            JTextArea textArea = new JTextArea(6, 60);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
            reader.close();

            JDialog dialog = new JDialog();
            dialog.add(scrollPane);
            dialog.pack();
            dialog.setTitle("Arquivo de solicitacoes");
            dialog.setVisible(true);
            dialog.setResizable(false);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loadItem) {

            JFileChooser fileChooser = new JFileChooser();

            //int response = fileChooser.showOpenDialog(null); // selecionar arquivo
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                openNewWindow("arquivo salvo");
                //mostrar o arquivo salvo
            }
        }
        if (e.getSource() == saveItem) {
            if(file != null) {
                ArrayList<Solicitacao> solicitacoes = lerSolicitacao(file);

                if(solicitacoes != null){
                    mostrarConteudoDoArquivo(file); // Método para mostrar o conteúdo do arquivo
                    //openNewWindow("solicitações lidas");
                } else {
                    openNewWindow("nao foi possivel ler as solicitacoes");
                }
            }
            // ao retornando que arquivo foi lido
        }

        if (e.getSource() == exitItem){
            file = null;
            if(file == null){
                openNewWindow("sem arquivo salvo");
            }
        }
    }
}
