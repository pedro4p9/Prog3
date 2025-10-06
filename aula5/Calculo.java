package aula5;

public class Calculo {
    int a;
    int b;

    public void calcularDivisao() {
        try {
            int x = a / b;
            System.out.println("Resultado da divisão: " + x);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero.");
        }finally {
            System.out.println("Cálculo finalizado.");
        }
    }

    public static void main(String[] args) {
        Calculo calc = new Calculo();
        calc.a = 5;
        calc.b = 0;
        calc.calcularDivisao();
    }
}