import java.util.ArrayList;
import java.util.Scanner;
public class NumeroEliminacao {
    public static void main(String[] args){
        try (Scanner scanner = new java.util.Scanner(System.in)) {
            ArrayList<Integer> numeros = new java.util.ArrayList<>();

            System.out.println("Digite 10 números inteiros:");
            for (int i = 0; i < 10; i++) {
                numeros.add(scanner.nextInt());
            }

            System.out.println("Números inseridos: " + numeros);

            int soma = 0;
            for (int num : numeros) {
                soma += num;
            }
            double media = soma / 10.0;

            System.out.println("Soma total: " + soma);
            System.out.println("Média: " + media);

            numeros.removeIf(n -> n % 2 == 0);
            System.out.println("Lista após remover números pares: " + numeros);
        }
    }
}
