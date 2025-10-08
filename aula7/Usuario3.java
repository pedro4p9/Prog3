package aula7;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;

public class Usuario3 {
    public static void main(String[] args) {
        try{
            InputStream arquivo = new FileInputStream("aula7/arquivo.txt");
            BufferedReader leitor = new BufferedReader(new java.io.InputStreamReader(arquivo));
            String linha;
            while((linha = leitor.readLine()) != null){
                System.out.println(linha);
            }
            leitor.close();
        }catch (Exception e){
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
