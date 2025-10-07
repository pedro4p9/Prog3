import java.util.HashSet;
import java.util.Scanner;

public class PalavrasUnicas {
    public static void main(String[] args) {
        HashSet<String> palavras = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String entrada;

        System.out.println("Digite palavras (digite 'fim' para encerrar):");
        while (true) {
            entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            palavras.add(entrada);
        }
        System.out.println("\nPalavras únicas digitadas:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
        boolean encontrouJava = false;
        for (String palavra : palavras) {
            if (palavra.equalsIgnoreCase("java")) {
                encontrouJava = true;
                break;
            }
        }
        if (encontrouJava) {
            System.out.println("\nA palavra 'Java' foi digitada.");
        } else {
            System.out.println("\nA palavra 'Java' não foi digitada.");
        }
        scanner.close();
    }
}