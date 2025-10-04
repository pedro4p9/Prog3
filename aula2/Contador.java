package aula2;

public class Contador {
    private static int totalObjetos = 0;
    public Contador() {
        totalObjetos++;
    }
    public static void mostrarTotal() {
        System.out.println("Total de objetos criados: " + totalObjetos);
    }
    public static void main(String[] args) {
        new Contador();
        new Contador();
        Contador.mostrarTotal();
        new Contador();
        Contador.mostrarTotal(); 
    }
}

