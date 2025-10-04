

package aula3;

public class Pessoa2 {
    String nome;
    int idade;
    public Pessoa2(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    private class Aluno extends Pessoa2{
        String matricula;
        public String getMatricula(){
            return matricula;
        }
        public int getIdade(){
            return idade;
        }
        public String getNome(){
            return nome;
        }
        public void setMatricula(String matricula){
            this.matricula = matricula;
        }
        public void setIdade(int idade){
            this.idade = idade;
        }
        public void setNome(String nome){
            this.nome = nome;
        }
        public Aluno(){
            super("Desconhecido", 0);
            this.matricula = "0000";
        }
    }
    public static void main(String[] args){
        Aluno aluno = new Pessoa2("Desconhecido", 0).new Aluno();
        aluno.setNome("Ana");
        aluno.setIdade(20);
        aluno.setMatricula("2023001");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Matrícula: " + aluno.getMatricula());
    }
}
       