package Trabalho;

import java.time.LocalDate;

public abstract class Item {
    private String titulo;
    private String descricao;
    private LocalDate dataCadastro;
    public Item(String titulo, String descricao, LocalDate dataCadastro) {
        try{
            if (titulo == null || titulo.isEmpty()){
                throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
            }
            if (descricao == null || descricao.isEmpty()){
                throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
            }
            if (dataCadastro == null){
                throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
            }
            this.titulo = titulo;
            this.descricao = descricao;
            this.dataCadastro = dataCadastro;
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao criar item: " + e.getMessage());
            this.titulo = "Sem Título";
            this.descricao = "Sem Descrição";
            this.dataCadastro = LocalDate.now();
        }
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setTitulo(String titulo) {
        try{
            if (titulo == null || titulo.isEmpty()){
                throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
            }
            this.titulo = titulo;
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao definir título: " + e.getMessage());
            this.titulo = "Sem Título";
        }
    }
    public void setDescricao(String descricao) {
        try{
            if (descricao == null || descricao.isEmpty()){
                throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
            }
            this.descricao = descricao;
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao definir descrição: " + e.getMessage());
            this.descricao = "Sem Descrição";
        }
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        try{
            if (dataCadastro == null){
                throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
            }
            this.dataCadastro = dataCadastro;
        }catch (Exception e){
            System.out.println("Erro ao definir data de cadastro: " + e.getMessage());
            this.dataCadastro = LocalDate.now();
        }
    }
    public abstract String exibirDetalhes();

}
