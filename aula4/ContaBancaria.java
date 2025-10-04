package aula4;

public abstract class ContaBancaria {
    private String NomeTitular;
    protected double saldo;
    private int numeroConta;
    public ContaBancaria(String nomeTitular, int numeroConta){
        this.NomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }
    public String getNomeTitular(){
        return NomeTitular;
    }
    public int getNumeroConta(){
        return numeroConta;
    }
    public double getSaldo(){
        return saldo;
    }
    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);

}
