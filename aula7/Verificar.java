package aula7;
import java.io.File;
import java.util.Scanner;
public class Verificar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo ou diretório: ");
        String caminho = scanner.nextLine();
        File arquivo = new File(caminho);
        if(arquivo.exists()){
            System.out.println("O arquivo/diretório existe.");
            if(arquivo.isFile()){
                System.out.println("É um arquivo.");
                System.out.println("Tamanho: " + arquivo.length() + " bytes");
            }else if(arquivo.isDirectory()){
                System.out.println("É um diretório.");
                String[] arquivos = arquivo.list();
                System.out.println("Conteúdo do diretório:");
                if(arquivos != null){
                    for(String nome : arquivos){
                        System.out.println(nome);
                    }
                }
            }
        
        }else{
            System.out.println("O arquivo/diretório não existe.");
        }
        scanner.close();
    }
}   
