
package Trabalho;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class JanelaPrincipal extends JFrame {
    private GerenciadorItens gerenciador;
    private JTextField txtTitulo;
    private JTextArea txtDescricao;
    private JComboBox<String> comboTipo;
    private JTextField txtAutor;
    private JTextField txtPaginas;
    private JTextField txtDiretor;
    private JTextField txtDuracao;
    private JTextField txtBusca;
    private JTextArea areaResultados;
    private JPanel painelEspecifico;
    
    // Cor exclusiva do aluno #80ae84
    private final Color COR_EXCLUSIVA = new Color(128, 174, 132); // #80ae84
    private final Color COR_BOTAO = new Color(128, 174, 132); // #80ae84
    private final Color COR_DESTAQUE = new Color(128, 174, 122); // #80ae84
    
    public JanelaPrincipal() {
        gerenciador = new GerenciadorItens();
        inicializarComponentes();
        configurarLayout();
        aplicarCoresPersonalizadas();
    }
    
    private void inicializarComponentes() {
        setTitle("Sistema de Gerenciamento de Itens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        // Componentes básicos
        txtTitulo = new JTextField(20);
        txtDescricao = new JTextArea(3, 20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        
        // ComboBox para tipo
        comboTipo = new JComboBox<>(new String[]{"Livro", "Filme"});
        
        // Campos específicos para Livro
        txtAutor = new JTextField(20);
        txtPaginas = new JTextField(10);
        
        // Campos específicos para Filme
        txtDiretor = new JTextField(20);
        txtDuracao = new JTextField(10);
        
        // Painel específico (dinâmico)
        painelEspecifico = new JPanel(new CardLayout());
        
        JPanel painelLivro = new JPanel(new GridLayout(2, 2, 5, 5));
        painelLivro.add(new JLabel("Autor:"));
        painelLivro.add(txtAutor);
        painelLivro.add(new JLabel("Número de Páginas:"));
        painelLivro.add(txtPaginas);
        
        JPanel painelFilme = new JPanel(new GridLayout(2, 2, 5, 5));
        painelFilme.add(new JLabel("Diretor:"));
        painelFilme.add(txtDiretor);
        painelFilme.add(new JLabel("Duração (minutos):"));
        painelFilme.add(txtDuracao);
        
        painelEspecifico.add(painelLivro, "Livro");
        painelEspecifico.add(painelFilme, "Filme");
        
        // Busca
        txtBusca = new JTextField(15);
        
        // Área de resultados
        areaResultados = new JTextArea(15, 50);
        areaResultados.setEditable(false);
        areaResultados.setLineWrap(true);
        areaResultados.setWrapStyleWord(true);
    }
    
    private void configurarLayout() {
        setLayout(new BorderLayout(10, 10));
        
        // Painel superior - Barra de título personalizada
        JPanel painelSuperior = new JPanel(new BorderLayout());
        painelSuperior.setBackground(COR_EXCLUSIVA);
        painelSuperior.setPreferredSize(new Dimension(getWidth(), 60));
        painelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel lblTitulo = new JLabel("SISTEMA DE GERENCIAMENTO DE ITENS", JLabel.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        painelSuperior.add(lblTitulo, BorderLayout.CENTER);
        
        add(painelSuperior, BorderLayout.NORTH);
        
        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel lateral esquerdo - Cadastro
        JPanel painelLateral = new JPanel();
        painelLateral.setLayout(new BoxLayout(painelLateral, BoxLayout.Y_AXIS));
        painelLateral.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(COR_DESTAQUE, 2), "Cadastro de Item"));
        painelLateral.setBackground(new Color(240, 248, 255));
        
        JPanel painelBasico = new JPanel(new GridLayout(3, 2, 5, 5));
        painelBasico.setBackground(painelLateral.getBackground());
        painelBasico.add(new JLabel("Título:"));
        painelBasico.add(txtTitulo);
        painelBasico.add(new JLabel("Descrição:"));
        painelBasico.add(new JScrollPane(txtDescricao));
        painelBasico.add(new JLabel("Tipo:"));
        painelBasico.add(comboTipo);
        
        painelLateral.add(painelBasico);
        painelLateral.add(Box.createVerticalStrut(10));
        painelLateral.add(painelEspecifico);
        painelLateral.add(Box.createVerticalStrut(10));
        
        // Botões de ação principais
        JPanel painelBotoesAcao = new JPanel(new GridLayout(1, 2, 10, 5));
        painelBotoesAcao.setBackground(painelLateral.getBackground());
        
        JButton btnAdicionar = criarBotaoPersonalizado("Adicionar", COR_BOTAO);
        JButton btnListar = criarBotaoPersonalizado("Listar Todos", COR_BOTAO);
        
        painelBotoesAcao.add(btnAdicionar);
        painelBotoesAcao.add(btnListar);
        
        painelLateral.add(painelBotoesAcao);
        painelLateral.add(Box.createVerticalStrut(10));
        
        // Botões de exportação/importação
        JPanel painelBotoesArquivo = new JPanel(new GridLayout(1, 2, 10, 5));
        painelBotoesArquivo.setBackground(painelLateral.getBackground());
        
        JButton btnExportar = criarBotaoPersonalizado("Exportar Dados", COR_DESTAQUE);
        JButton btnImportar = criarBotaoPersonalizado("Importar Dados", COR_DESTAQUE);
        
        painelBotoesArquivo.add(btnExportar);
        painelBotoesArquivo.add(btnImportar);
        
        painelLateral.add(painelBotoesArquivo);
        
        // Painel central - Busca e Resultados
        JPanel painelCentral = new JPanel(new BorderLayout(10, 10));
        
        // Painel de busca
        JPanel painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelBusca.setBorder(BorderFactory.createTitledBorder("Busca por Título"));
        painelBusca.add(new JLabel("Título:"));
        painelBusca.add(txtBusca);
        JButton btnFiltrar = criarBotaoPersonalizado("Filtrar", COR_BOTAO);
        painelBusca.add(btnFiltrar);
        
        // Painel de resultados
        JPanel painelResultados = new JPanel(new BorderLayout());
        painelResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        JScrollPane scrollResultados = new JScrollPane(areaResultados);
        painelResultados.add(scrollResultados, BorderLayout.CENTER);
        
        painelCentral.add(painelBusca, BorderLayout.NORTH);
        painelCentral.add(painelResultados, BorderLayout.CENTER);
        
        // Adicionando todos os painéis à janela principal
        painelPrincipal.add(painelLateral, BorderLayout.WEST);
        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        
        add(painelPrincipal, BorderLayout.CENTER);
        
        // Configurar eventos
        configurarEventos(btnAdicionar, btnListar, btnFiltrar, btnExportar, btnImportar);
    }
    
    private void configurarEventos(JButton btnAdicionar, JButton btnListar, 
                                 JButton btnFiltrar, JButton btnExportar, 
                                 JButton btnImportar) {
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarItem();
            }
        });
        
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarTodos();
            }
        });
        
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPorTitulo();
            }
        });
        
        btnExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportarDados();
            }
        });
        
        btnImportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importarDados();
            }
        });
        
        comboTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarPainelEspecifico();
            }
        });
        
        mudarPainelEspecifico();
    }
    
    private JButton criarBotaoPersonalizado(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setBackground(corFundo);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 12));
        botao.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(corFundo.darker(), 2),
            BorderFactory.createEmptyBorder(8, 15, 8, 15)
        ));
        
        // Efeito hover
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(corFundo.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(corFundo);
            }
        });
        
        return botao;
    }
    
    private void aplicarCoresPersonalizadas() {
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void mudarPainelEspecifico() {
        CardLayout cl = (CardLayout) painelEspecifico.getLayout();
        String tipoSelecionado = (String) comboTipo.getSelectedItem();
        cl.show(painelEspecifico, tipoSelecionado);
    }
    
    private void adicionarItem() {
        try {
            String titulo = txtTitulo.getText().trim();
            String descricao = txtDescricao.getText().trim();
            String tipo = (String) comboTipo.getSelectedItem();
            LocalDate data = LocalDate.now();
            
            if (titulo.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Título e descrição são obrigatórios!", 
                    "Erro de Validação", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Item item = null;
            
            if ("Livro".equals(tipo)) {
                String autor = txtAutor.getText().trim();
                String paginasStr = txtPaginas.getText().trim();
                
                if (autor.isEmpty() || paginasStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Autor e número de páginas são obrigatórios para Livros!", 
                        "Erro de Validação", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    int paginas = Integer.parseInt(paginasStr);
                    item = new Livro(titulo, descricao, data, autor, paginas);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                        "Número de páginas deve ser um valor numérico válido!", 
                        "Erro de Formato", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
            } else if ("Filme".equals(tipo)) {
                String diretor = txtDiretor.getText().trim();
                String duracaoStr = txtDuracao.getText().trim();
                
                if (diretor.isEmpty() || duracaoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                        "Diretor e duração são obrigatórios para Filmes!", 
                        "Erro de Validação", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    int duracao = Integer.parseInt(duracaoStr);
                    item = new Filme(titulo, descricao, data, diretor, duracao);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                        "Duração deve ser um valor numérico válido!", 
                        "Erro de Formato", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (item != null) {
                gerenciador.adicionarItem(item);
                limparCampos();
                JOptionPane.showMessageDialog(this, 
                    "Item adicionado com sucesso!", 
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao adicionar item: " + e.getMessage(), 
                "Erro de Validação", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro inesperado: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listarTodos() {
        try {
            List<Item> itens = gerenciador.listarTodos();
            exibirItens(itens);
            
            Map<String, Long> contagem = gerenciador.contarPorTipo();
            if (!contagem.isEmpty()) {
                areaResultados.append("\n\n--- CONTAGEM POR TIPO ---\n");
                for (Map.Entry<String, Long> entry : contagem.entrySet()) {
                    areaResultados.append(entry.getKey() + ": " + entry.getValue() + " item(s)\n");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao listar itens: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void filtrarPorTitulo() {
        String tituloBusca = txtBusca.getText().trim();
        if (tituloBusca.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Digite um título para buscar!", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            List<Item> itens = gerenciador.buscarPorTitulo(tituloBusca);
            exibirItens(itens);
            
            if (itens.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Nenhum item encontrado com o título: " + tituloBusca, 
                    "Busca sem Resultados", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao buscar itens: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportarDados() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Exportar Dados");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("itens_exportados.txt"));
        
        int resultado = fileChooser.showSaveDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try {
                gerenciador.exportarParaArquivo(arquivo.getAbsolutePath());
                JOptionPane.showMessageDialog(this, 
                    "Dados exportados com sucesso para:\n" + arquivo.getAbsolutePath(), 
                    "Exportação Concluída", 
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Erro ao exportar dados: " + e.getMessage(), 
                    "Erro na Exportação", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void importarDados() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar Dados");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Arquivos de texto (*.txt)", "txt"));
        
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try {
                int tamanhoAntes = gerenciador.listarTodos().size();
                
                gerenciador.importarDeArquivo(arquivo.getAbsolutePath());
                
                int tamanhoDepois = gerenciador.listarTodos().size();
                int itensImportados = tamanhoDepois - tamanhoAntes;
                
                JOptionPane.showMessageDialog(this, 
                    itensImportados + " item(s) importado(s) com sucesso!\n" +
                    "Total de itens no sistema: " + tamanhoDepois, 
                    "Importação Concluída", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                listarTodos();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Erro ao importar dados: " + e.getMessage(), 
                    "Erro na Importação", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void exibirItens(List<Item> itens) {
        areaResultados.setText("");
        
        if (itens.isEmpty()) {
            areaResultados.setText("Nenhum item encontrado.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Total de itens: ").append(itens.size()).append("\n\n");
        
        for (Item item : itens) {
            sb.append(item.exibirDetalhes()).append("\n");
            sb.append("----------------------------------------\n\n");
        }
        
        areaResultados.setText(sb.toString());
        areaResultados.setCaretPosition(0);
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
        // Versão simplificada que não usa LookAndFeel
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
}