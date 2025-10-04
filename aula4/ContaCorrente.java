package aula4;
public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String nomeTitular, int numeroConta) {
        super(nomeTitular, numeroConta);
    }
    public boolean sacar(double valor) {
        double valorComTaxa = valor + 1.00;
        if (saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            return true;
        }
        return false;
    }
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
}