import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Objects;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    MyFrame(){
        ImageIcon arquivoOriginal = new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/arquivo.png")));
        Image imagemRedimensionada = arquivoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Altere 100, 100 para o tamanho desejado
        ImageIcon arquivoRedimensionado = new ImageIcon(imagemRedimensionada);

        ImageIcon iconSIGAA =new ImageIcon(Objects.requireNonNull(Menu.class.getResource("/logo.png")));

        button = new JButton();
        button.setBounds(150, 125, 230, 100);
        button.addActionListener(this);
        button.setText("Ler arquivo");
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
        this.setLayout(null);
        this.setSize(500, 500);
        this.add(label, BorderLayout.CENTER);
        this.add(headerPanel);
        this.add(button);
        this.setIconImage(iconSIGAA.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            System.out.println("poo");
        }
    }
}
