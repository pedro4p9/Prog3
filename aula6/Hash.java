import java.util.HashMap;
import java.util.Scanner;
public class Hash {
   public static void main(String[] args) {
    HashMap<String,Integer> pessoa = new HashMap<>();
    pessoa.put("Pedro", 25);
    pessoa.put("Ana", 30);
    pessoa.put("João", 20);
    pessoa.put("Maria", 28);
    pessoa.put("Jorge", 22);
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome da pessoa que deseja buscar: ");
    String nome = scanner.nextLine();

    if(pessoa.containsKey(nome)){
        System.out.println("Idade de " + nome + ": " + pessoa.get(nome));
    }else{
        System.out.println("Pessoa não encontrada.");
    }

    System.out.println("Digite o nome da pessoa que deseja remover: ");
    String nomeRemover = scanner.nextLine();
    if(pessoa.containsKey(nomeRemover)){
        pessoa.remove(nomeRemover);
        System.out.println(nomeRemover + " removido com sucesso.");
    }else{
        System.out.println("Pessoa não encontrada.");
    }
    System.out.println("Todas as pessoas cadastradas:");
    for(String chave : pessoa.keySet()){
        System.out.println(chave + ": " + pessoa.get(chave));
    }
    scanner.close();
   }
}
