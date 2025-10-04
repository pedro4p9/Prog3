package aula4;
public class Main{
    ContaBancaria contaBancaria;
    ContaBancaria contaCorrente;
    ContaBancaria contaPoupanca;
    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaCorrente("João", 12345);
        ContaBancaria contaPoupanca = new ContaPoupanca("Maria", 67890);
        contaCorrente.depositar(500.0);
        contaPoupanca.depositar(1000.0);
        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
        contaCorrente.sacar(100.0);
        contaPoupanca.sacar(200.0);
        System.out.println("Saldo Conta Corrente após saque: " + contaCorrente.getSaldo());
        System.out.println("Saldo Conta Poupança após saque: " + contaPoupanca.getSaldo());
    }
} 
