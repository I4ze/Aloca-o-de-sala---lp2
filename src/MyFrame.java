import classes.Solicitacao;
import classes.Solicitacao_Fixa;
import classes.Solicitacao_eventual;

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

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    File file;

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

        button = new JButton();
        button.setBounds(150, 125, 230, 100);
        button.addActionListener(this);
        button.setText("Escolher Arquivo");
        button.setFocusable(false);
        button.setIcon(arquivoRedimensionado);

        JLabel label = new JLabel();
        label.setText("Bem-Vindo ao SIGAA");
        label.setBackground(Color.WHITE);
        label.revalidate();
        label.repaint();
        label.setVisible(true);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBounds(50, 0,200, 100);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setBounds(0, 0, 500, 100);
        headerPanel.setLayout(null);
        headerPanel.add(label);
        //headerPanel.add(button);

        JFrame frame = new JFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("SIGAA GERALDO");
        this.setLayout(new FlowLayout());
        this.setSize(500, 500);
        this.add(label, BorderLayout.CENTER);
        this.add(headerPanel);
        this.add(button);
        this.setIconImage(iconSIGAA.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setResizable(false);

        //criando o menu

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loadItem) {

            JFileChooser fileChooser = new JFileChooser();

            //int response = fileChooser.showOpenDialog(null); // selecionar arquivo
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
            if (file != null) {
                ArrayList <Solicitacao> solicitacoes = lerSolicitacao(file);
                System.out.println("aaaa");
            }
        }
    }
