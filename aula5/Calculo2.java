package aula5;

public class Calculo2 {
    public void CalcularRaiz(int numero){
        try {
            if (numero < 0) {
                throw new IllegalArgumentException("Número negativo não tem raiz quadrada real.");
            }
            double resultado = Math.sqrt(numero);
            System.out.println("A raiz quadrada de " + numero + " é: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }finally {
            System.out.println("Cálculo finalizado.");
        }
    }
    public static void main(String[] args) {
        Calculo2 calc = new Calculo2();
        calc.CalcularRaiz(16); 
        calc.CalcularRaiz(-4);  
    }
}
