package aula4;

public class Usuario {
    public enum NivelAcesso{BASICO,INTERMEDIRIO}
    String nome;
    NivelAcesso nivel;
    public Usuario(String nome,NivelAcesso nivel){
        this.nome = nome;
        this.nivel = nivel;
    }
    public void mensaem(){
        System.out.println("Olá, " + nome + "! Seu nível de acesso é: " + nivel);
    }
    public static void main(String[] args){
        Usuario user1 = new Usuario("Pedro",NivelAcesso.BASICO);
        Usuario user2 = new Usuario("Ana",NivelAcesso.INTERMEDIRIO);
        Usuario user3 = new Usuario("Tales",NivelAcesso.BASICO);
        user1.mensaem();
        user2.mensaem();
        user3.mensaem();
    }
}
