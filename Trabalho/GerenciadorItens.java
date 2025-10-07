package Trabalho;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
    public static void main(String[] args) {
        GerenciadorItens gerenciador = new GerenciadorItens();
        try {
            Filme filme1 = new Filme("Inception", "Sci-fi thriller", java.time.LocalDate.of(2020, 8, 15), "Christopher Nolan", 148);
            Filme filme2 = new Filme("The Matrix", "Sci-fi action", java.time.LocalDate.of(1999, 3, 31), "The Wachowskis", 136);
            Livro livro1 = new Livro("1984", "Dystopian novel", java.time.LocalDate.of(1949, 6, 8), "George Orwell", 328);
            Livro livro2 = new Livro("Brave New World", "Dystopian novel", java.time.LocalDate.of(1932, 1, 1), "Aldous Huxley", 311);

            gerenciador.adicionarItem(filme1);
            gerenciador.adicionarItem(filme2);
            gerenciador.adicionarItem(livro1);
            gerenciador.adicionarItem(livro2);

            System.out.println("Todos os itens:");
            for (Item item : gerenciador.listarTodos()) {
                System.out.println(item.exibirDetalhes());
                System.out.println();
            }

            System.out.println("Buscar por título '1984':");
            for (Item item : gerenciador.buscarPorTitulo("1984")) {
                System.out.println(item.exibirDetalhes());
                System.out.println();
            }

            System.out.println("Contagem por tipo:");
            Map<String, Long> contagem = gerenciador.contarPorTipo();
            contagem.forEach((tipo, quantidade) -> System.out.println(tipo + ": " + quantidade));
        } catch (Exception e) {
            System.out.println("Erro no main: " + e.getMessage());
        }
    }
}