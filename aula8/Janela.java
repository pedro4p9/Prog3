package aula8;
import javax.swing.*;
import java.awt.event.*;
public class Janela {
    public static void main(String []args){
        JFrame frame = new JFrame("Bem vindo ao Programação");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Olá, Seja bem vindo!");
        label.setBounds(70,20,200,30);
        frame.add(label);

        JButton botao = new JButton("Fechar");
        botao.setBounds(100,70,100,30);
        frame.add(botao);

        botao.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
