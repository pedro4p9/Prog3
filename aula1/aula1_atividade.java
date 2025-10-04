public class aula1_atividade {
    public static void main(String[] args) {
        int n = 30;
        int a = 1, b = 1;
        System.out.print(a + " \n");
        for (int i = 1; i < n; i++) {
            System.out.print(b + "\n ");
            int x = b;
            b = a + b;
            a = x;
        }
    }
}