package aula3;

public class Pessoa {
    String nome;
    int idade;
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    private class Aluno extends Pessoa{
        String matricula;
        public Aluno(String nome, int idade, String matricula){
            super(nome, idade);
            this.matricula = matricula;
        }
    }
    public static void main(String[] args){
        Aluno aluno = new Pessoa("João", 20).new Aluno("João", 20, "2023001");
        System.out.println("Aluno: " + aluno.nome + ", Idade: " + aluno.idade + ", Matrícula: " + aluno.matricula);
    }
}
