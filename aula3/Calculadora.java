package aula3;

public class Calculadora {
    void somar(int a, int b){
        System.out.println("Soma: " + (a + b));
    }
    void somar(double a, double b){
        System.out.println("Soma: " + (a + b));
    }
    void somar(int a, int b, int c){
        System.out.println("Soma: " + (a + b + c)); 
    }
    public static void main(String[] args){
        Calculadora calc = new Calculadora();
        calc.somar(5, 10);
        calc.somar(5.5, 10.2);
        calc.somar(1, 2, 3);
    }
}
