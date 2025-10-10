package aula8;
import javax.swing.*;
import java.awt.event.*;
public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label1 = new JLabel("Número 1:");
        label1.setBounds(50, 50, 100, 30);
        frame.add(label1);

        JTextField campoNum1 = new JTextField();
        campoNum1.setBounds(150, 50, 150, 30);
        frame.add(campoNum1);

        JLabel label2 = new JLabel("Número 2:");
        label2.setBounds(50, 100, 100, 30);
        frame.add(label2);

        JTextField campoNum2 = new JTextField();
        campoNum2.setBounds(150, 100, 150, 30);
        frame.add(campoNum2);

        JLabel labelOperacao = new JLabel("Operação:");
        labelOperacao.setBounds(50, 150, 100, 30);
        frame.add(labelOperacao);

        String[] operacoes = {"Somar", "Subtrair", "Multiplicar", "Dividir"};
        JComboBox<String> comboOperacoes = new JComboBox<>(operacoes);
        comboOperacoes.setBounds(150, 150, 150, 30);
        frame.add(comboOperacoes);

        JCheckBox chkMostrarResultado = new JCheckBox("Mostrar Resultado");
        chkMostrarResultado.setBounds(150, 190, 150, 30);
        frame.add(chkMostrarResultado);

        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.setBounds(150, 230, 100, 30);
        frame.add(botaoCalcular);

             botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(campoNum1.getText());
                    double num2 = Double.parseDouble(campoNum2.getText());
                    String operacao = (String) comboOperacoes.getSelectedItem();
                    double resultado = 0;

                    switch (operacao) {
                        case "Somar": resultado = num1 + num2; break;
                        case "Subtrair": resultado = num1 - num2; break;
                        case "Multiplicar": resultado = num1 * num2; break;
                        case "Dividir":
                            if (num2 == 0) {
                                JOptionPane.showMessageDialog(frame, "Erro: divisão por zero.");
                                return;
                            }
                            resultado = num1 / num2;
                            break;
                    }

                    if (chkMostrarResultado.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Resultado: " + resultado);
                    } else {
                        JLabel resultadoLabel = new JLabel("Resultado: " + resultado);
                        resultadoLabel.setBounds(30, 200, 200, 25);
                        frame.add(resultadoLabel);
                        frame.repaint();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira números válidos.");
                }
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
