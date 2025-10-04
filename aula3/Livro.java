package aula3;

public class Livro {
    String tiulo;
    String autor;
    public Livro(String tiulo, String autor){
        this.tiulo = tiulo;
        this.autor = autor;
    }
    public Livro(){
        this.tiulo = "Desconhecido";
        this.autor = "Desconhecido";
    }
    public static void main(String[] args){
        Livro livro1 = new Livro("1984", "George Orwell");
        Livro livro2 = new Livro();
        System.out.println("Livro 1: " + livro1.tiulo + " de " + livro1.autor);
        System.out.println("Livro 2: " + livro2.tiulo + " de " + livro2.autor);
    }
    
}
