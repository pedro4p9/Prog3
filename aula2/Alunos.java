package aula2;
import java.util.ArrayList;
import java.util.Iterator;
public class Alunos{
    ArrayList<String> alunos = new ArrayList<>();
    public void adicionarAluno(String nome){
        alunos.add(nome);
    }
    public void listarAlunos(){
        System.out.println("Lista de Alunos:");
        Iterator<String> it = alunos.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public void removerAluno(String nome){
        if(alunos.remove(nome)){
            System.out.println("Aluno " + nome + " removido com sucesso.");
        } else {
            System.out.println("Aluno " + nome + " não encontrado.");
        }
    }
    public static void main(String[] args) {
        Alunos turma = new Alunos();
        turma.adicionarAluno("Pedro");
        turma.adicionarAluno("Maria");
        turma.adicionarAluno("João");
        turma.adicionarAluno("Ana");
        turma.adicionarAluno("Lucas");
        turma.listarAlunos();
        turma.removerAluno("João");
        turma.listarAlunos();
    }
}