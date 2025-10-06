package Trabalho;
import java.time.LocalDate;

public class Livro extends Item {
    private String autor;
    private int numeroPaginas;

    public Livro(String titulo, String descricao, LocalDate dataCadastro, String autor, int numeroPaginas) {
        super(titulo, descricao, dataCadastro);
        try{
            if (autor == null || autor.isEmpty()){
                throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
            }
            if(numeroPaginas <= 0){
                throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
            }
            this.autor = autor;
            this.numeroPaginas = numeroPaginas;
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao criar livro: " + e.getMessage());
            this.autor = "Desconhecido";
            this.numeroPaginas = 1;
        }
    }
    public String getAutor() {
        return autor;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty()){
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        this.autor = autor;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        if(numeroPaginas <= 0){
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.numeroPaginas = numeroPaginas;
    }
    @Override
    public String exibirDetalhes() {
        return "Livro: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nData de Cadastro: " + getDataCadastro() +
               "\nAutor: " + autor + "\nNúmero de Páginas: " + numeroPaginas;
    }

    public static void main(String[] args) {
        try {
            Livro livro = new Livro("1984", "Dystopian novel", LocalDate.of(2021, 5, 20), "George Orwell", 328);
            System.out.println(livro.exibirDetalhes());

            Livro livroInvalido = new Livro("Teste", "Descrição", LocalDate.now(), "", -10);
            System.out.println(livroInvalido.exibirDetalhes());
        } catch (Exception e) {
            System.out.println("Erro no main: " + e.getMessage());
        }
    }
}
