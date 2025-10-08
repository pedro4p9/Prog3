package aula7;
import java.io.PrintStream;
import java.util.Scanner;
public class Leitura {
    public static void main(String[] args) {
        System.out.println("Digite linhas de texto (digite 'FIM' para encerrar):");
        Scanner scanner = new Scanner(System.in);

        try(PrintStream arquivo = new PrintStream("aula7/saida.txt")){
           while(true){
            String linha = scanner.nextLine();
            if(linha.equalsIgnoreCase("FIM")){
                break;
            }
            arquivo.println(linha);
            }
        }catch (Exception e){
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
