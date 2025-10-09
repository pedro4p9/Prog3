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
    @Override
    public String exportar() {
        return String.join(",", "Filme", getTitulo(), getDiretor(), getDescricao(), getDataCadastro().toString(), String.valueOf(getDuracaoMinutos()));
    }

    public static Filme reconstruirDeString(String linha) {
        try {
            String[] partes = linha.split(",");
            if (partes.length == 6 && partes[0].equalsIgnoreCase("Filme")) {
                return new Filme(
                    partes[1], // título
                    partes[3], // descrição
                    LocalDate.parse(partes[4]), // data
                    partes[2], // diretor
                    Integer.parseInt(partes[5]) // duração
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao reconstruir Filme: " + e.getMessage());
        }
        return null;
    }

}
