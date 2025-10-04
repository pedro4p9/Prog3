package aula3;

public class ContaBancaria {
    int numeroConta;
    void ToString(){
        System.out.println("Número da Conta: " + numeroConta);
    }
    void equals(ContaBancaria outraConta){
        if(this.numeroConta == outraConta.numeroConta){
            System.out.println("Contas iguais");
        } else {
            System.out.println("Contas diferentes");
        }
    }
    public static void main(String[] args){
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();
        conta1.numeroConta = 1234;
        conta2.numeroConta = 12345;
        conta1.ToString();
        conta2.ToString();
        conta1.equals(conta2);
    }
}
