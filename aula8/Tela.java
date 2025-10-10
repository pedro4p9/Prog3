package aula8;

import javax.swing.*;
import java.awt.event.*;

public class Tela {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login de Usuário");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Usuario:");
        label.setBounds(50, 50, 100, 30);
        frame.add(label);

        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(150, 50, 150, 30);
        frame.add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 100, 100, 30);
        frame.add(labelSenha);

        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(150, 100, 150, 30);
        frame.add(campoSenha);

        JButton botaoLogin = new JButton("Login");
        botaoLogin.setBounds(150, 150, 100, 30);
        frame.add(botaoLogin);

        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                JOptionPane.showMessageDialog(frame, "Bem-vindo, " + usuario + "!");
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
