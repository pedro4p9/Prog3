package Trabalho;

import java.time.LocalDate;
public class Filme extends Item {
    private String diretor;
    private int duracaoMinutos;
    public Filme(String titulo, String descricao, LocalDate dataCadastro, String diretor, int duracaoMinutos) {
        super(titulo, descricao, dataCadastro);
        try{
            if(diretor == null || diretor.isEmpty()){
                throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
            }
            if(duracaoMinutos <= 0){
                throw new IllegalArgumentException("Duração deve ser maior que zero.");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao criar filme: " + e.getMessage());
            this.diretor = "Desconhecido";
            this.duracaoMinutos = 1;
        }
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }
    public String getDiretor() {
        return diretor;
    }
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    public void setDiretor(String diretor) {
        if (diretor == null || diretor.isEmpty()){
            throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
        }
        this.diretor = diretor;
    }
    public void setDuracaoMinutos(int duracaoMinutos) {
        if(duracaoMinutos <= 0){
            throw new IllegalArgumentException("Duração deve ser maior que zero.");
        }
        this.duracaoMinutos = duracaoMinutos;
    }
    @Override
    public String exibirDetalhes() {
        return "\nFilme: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nData de Cadastro: " + getDataCadastro() +
               "\nDiretor: " + diretor + "\nDuração (minutos): " + duracaoMinutos;
    }
    public static void main(String[] args) {
        try {
            Filme filme = new Filme("Inception", "Sci-fi thriller", LocalDate.of(2020, 8, 15), "Christopher Nolan", 148);
            System.out.println(filme.exibirDetalhes());

            Filme filmeInvalido = new Filme("Teste", "Descrição", LocalDate.now(), "", -120);
            System.out.println(filmeInvalido.exibirDetalhes());
        } catch (Exception e) {
            System.out.println("Erro no main: " + e.getMessage());
        }
    }
}
