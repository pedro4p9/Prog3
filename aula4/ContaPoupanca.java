package aula4;

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String nomeTitular, int numeroConta) {
        super(nomeTitular, numeroConta);
    }
    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
}
