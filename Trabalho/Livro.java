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
    @Override
    public String exportar() {
        return String.join(",", "Livro", getTitulo(), getAutor(), getDescricao(), getDataCadastro().toString(), String.valueOf(getNumeroPaginas()));
    }

    public static Livro reconstruirDeString(String linha) {
        try {
            String[] partes = linha.split(",");
            if (partes.length == 6 && partes[0].equalsIgnoreCase("Livro")) {
                return new Livro(
                    partes[1], // título
                    partes[3], // descrição
                    LocalDate.parse(partes[4]), // data
                    partes[2], // autor
                    Integer.parseInt(partes[5]) // páginas
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao reconstruir Livro: " + e.getMessage());
        }
        return null;
    }
}
