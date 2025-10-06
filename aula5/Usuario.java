package aula5;

import java.util.Scanner;

public class Usuario {
    public void SolicitarUsuario(int numero){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Digite um numero inteiro: ");
            String input = scanner.nextLine();
            int numeroConvertido = Integer.parseInt(input);
            System.out.println("Você digitou o número: " + numeroConvertido);
        }catch (NumberFormatException e){
            System.out.println("Erro: Entrada inválida");
        }finally {
            System.out.println("Processo finalizado.");
            scanner.close();
    }

    }
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.SolicitarUsuario(0);
    }
}
