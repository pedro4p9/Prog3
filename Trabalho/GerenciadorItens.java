package Trabalho;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.io.FileInputStream;
public class GerenciadorItens {
    private List<Item> itens = new ArrayList<>();

    void adicionarItem(Item item){
        itens.add(item);
        try{
            if(item == null){
                throw new IllegalArgumentException("Item não pode ser nulo.");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    List<Item> listarTodos(){
        List<Item> copia = new ArrayList<>(itens);
        try{
            if(itens.isEmpty()){
                throw new IllegalStateException("Nenhum item cadastrado.");
            }
        }catch (IllegalStateException e){
            System.out.println("Erro ao listar itens: " + e.getMessage());
        }
        Collections.sort(copia, Comparator.comparing(Item::getTitulo, String.CASE_INSENSITIVE_ORDER));
        return copia;
    }   

    List<Item> buscarPorTitulo(String titulo){
        try{
            if(titulo == null || titulo.isEmpty()){
                throw new IllegalArgumentException("Título de busca não pode ser nulo ou vazio.");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao buscar por título: " + e.getMessage());
            return new ArrayList<>();
        }
        return itens.stream()
                .filter(item -> item.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    Map<String, Long> contarPorTipo(){
        try{
            if(itens.isEmpty()){
                throw new IllegalStateException("Nenhum item cadastrado.");
            }
        }catch (IllegalStateException e){
            System.out.println("Erro ao contar por tipo: " + e.getMessage());
            return Collections.emptyMap();
        }
        return itens.stream()
                .collect(Collectors.groupingBy(item -> item.getClass().getSimpleName(), Collectors.counting()));
    }
    void exportarParaArquivo(String caminho){
        try (FileWriter writer = new FileWriter(caminho)) {
            for (Item item : itens) {
                writer.write(item.exportar() + "\n");
            }
            System.out.println("Itens exportados com sucesso para: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao exportar para o arquivo: " + e.getMessage());
        }
    }
    void importarDeArquivo(String caminho) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                try {
                    // Processar formato com parênteses
                    if (linha.startsWith("Livro,") || linha.startsWith("Filme,")) {
                        // Remover parênteses se existirem
                        linha = linha.replace("(", ",").replace(")", "");
                        
                        String[] partes = linha.split(",");
                        if (partes.length == 6) {
                            if (partes[0].equalsIgnoreCase("Livro")) {
                                Livro livro = new Livro(
                                    partes[1], // título
                                    partes[3], // descrição
                                    LocalDate.parse(partes[4]), // data
                                    partes[2], // autor
                                    Integer.parseInt(partes[5]) // páginas
                                );
                                adicionarItem(livro);
                            } else if (partes[0].equalsIgnoreCase("Filme")) {
                                Filme filme = new Filme(
                                    partes[1], // título
                                    partes[3], // descrição
                                    LocalDate.parse(partes[4]), // data
                                    partes[2], // diretor
                                    Integer.parseInt(partes[5]) // duração
                                );
                                adicionarItem(filme);
                            }
                        }
                    } else {
                        System.out.println("Linha com formato desconhecido: " + linha);
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao processar linha: " + linha + ". Detalhes: " + e.getMessage());
                }
            }
            System.out.println("Itens importados com sucesso de: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao importar do arquivo: " + e.getMessage());
        }
    }
}