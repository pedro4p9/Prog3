package Trabalho;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class MainWindow extends JFrame {

    private JTextField txtTitulo, txtDescricao, txtAutor, txtPaginas, txtDiretor, txtDuracao, txtBusca;
    private JComboBox<String> comboTipo;
    private JTextArea textArea;
    private GerenciadorItens gerenciador;

    public MainWindow() {
        super("Gestor de Itens");
        gerenciador = new GerenciadorItens();
        configurarJanela();
    }

    private void configurarJanela() {
        setLayout(new BorderLayout());

        Color corPrincipal = new Color(128,174,123);

        JLabel lblTitulo = new JLabel("Gestor de Itens", SwingConstants.CENTER);
        lblTitulo.setOpaque(true);
        lblTitulo.setBackground(corPrincipal);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel painelCentral = new JPanel(new GridLayout(0, 2, 5, 5));

        painelCentral.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        painelCentral.add(txtTitulo);

        painelCentral.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        painelCentral.add(txtDescricao);

        painelCentral.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[]{"Livro", "Filme"});
        painelCentral.add(comboTipo);

        painelCentral.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        painelCentral.add(txtAutor);

        painelCentral.add(new JLabel("Páginas:"));
        txtPaginas = new JTextField();
        painelCentral.add(txtPaginas);

        painelCentral.add(new JLabel("Diretor:"));
        txtDiretor = new JTextField();
        painelCentral.add(txtDiretor);

        painelCentral.add(new JLabel("Duração (min):"));
        txtDuracao = new JTextField();
        painelCentral.add(txtDuracao);

        JPanel painelLateral = new JPanel();
        painelLateral.setBackground(corPrincipal);
        painelLateral.setLayout(new GridLayout(0, 1, 10, 10));

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnListar = new JButton("Listar");
        JButton btnExportar = new JButton("Exportar Dados");
        JButton btnImportar = new JButton("Importar Dados");

        painelLateral.add(btnAdicionar);
        painelLateral.add(btnListar);
        painelLateral.add(btnExportar);
        painelLateral.add(btnImportar);

        add(painelCentral, BorderLayout.CENTER);
        add(painelLateral, BorderLayout.EAST);

        JPanel painelInferior = new JPanel(new BorderLayout());

        txtBusca = new JTextField();
        JButton btnFiltrar = new JButton("Filtrar");
        painelInferior.add(txtBusca, BorderLayout.CENTER);
        painelInferior.add(btnFiltrar, BorderLayout.EAST);
        add(painelInferior, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.WEST);

        btnAdicionar.addActionListener(e -> adicionarItem());
        btnListar.addActionListener(e -> listarItens());
        btnFiltrar.addActionListener(e -> filtrarItens());
        btnExportar.addActionListener(e -> exportarDados());
        btnImportar.addActionListener(e -> importarDados());

        comboTipo.addActionListener(e -> atualizarCampos());
        atualizarCampos();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarCampos() {
        boolean isLivro = comboTipo.getSelectedItem().equals("Livro");
        txtAutor.setEnabled(isLivro);
        txtPaginas.setEnabled(isLivro);
        txtDiretor.setEnabled(!isLivro);
        txtDuracao.setEnabled(!isLivro);
    }

    private void adicionarItem() {
        try {
            String titulo = txtTitulo.getText().trim();
            String descricao = txtDescricao.getText().trim();
            if (titulo.isEmpty() || descricao.isEmpty())
                throw new Exception("Título e descrição são obrigatórios.");

            String tipo = (String) comboTipo.getSelectedItem();

            if (tipo.equals("Livro")) {
                String autor = txtAutor.getText().trim();
                int paginas = Integer.parseInt(txtPaginas.getText().trim());
                gerenciador.adicionarItem(new Livro(titulo, descricao, LocalDate.now(), autor, paginas));
            } else {
                String diretor = txtDiretor.getText().trim();
                int duracao = Integer.parseInt(txtDuracao.getText().trim());
                gerenciador.adicionarItem(new Filme(titulo, descricao, LocalDate.now(), diretor, duracao));
            }

            JOptionPane.showMessageDialog(this, "Item adicionado com sucesso!");
            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Campos numéricos inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarItens() {
        textArea.setText(String.join("\n", gerenciador.listarTodos().stream().map(Object::toString).collect(Collectors.toList())));
    }

    private void filtrarItens() {
        String termo = txtBusca.getText().trim();
        textArea.setText(String.join("\n", gerenciador.buscarPorTitulo(termo).stream().map(Object::toString).collect(Collectors.toList())));
    }

    private void exportarDados() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                gerenciador.exportarParaArquivo(chooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Dados exportados com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage());
            }
        }
    }

    private void importarDados() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                gerenciador.importarDeArquivo(chooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Dados importados com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao importar: " + e.getMessage());
            }
        }
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtAutor.setText("");
        txtPaginas.setText("");
        txtDiretor.setText("");
        txtDuracao.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
